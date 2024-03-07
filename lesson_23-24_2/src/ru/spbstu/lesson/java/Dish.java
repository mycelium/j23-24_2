package ru.spbstu.lesson.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dish {
	
	private static final int SERVER_PORT = 10000;

	private static Logger logger = LoggerFactory.getLogger(Dish.class);
	
	private static AtomicInteger portions = new AtomicInteger(500);

	private static int takePortion(int count) {
		int previous = portions.getAndAccumulate(count, (current, x) -> {
			if (current - x > 0) {
				return current - x;
			}
			return current;
		});
		
		if (previous - count > 0) {
			logger.info("Taken: " + count);
			return count;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			ServerSocket server = new ServerSocket(SERVER_PORT);
			logger.debug("Started server at port " + SERVER_PORT);
			ExecutorService service = Executors.newCachedThreadPool();
			
			while (true) {
				Socket client = server.accept();
				
				service.execute(() -> {
					
					handleClient(client);
					
				});
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Soket creation", e);
		}

	}
	
	static void handleClient(Socket client) {
		ObjectOutputStream outputStream;
		try {
			outputStream = new ObjectOutputStream(client.getOutputStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		try (var inputObject = new ObjectInputStream(client.getInputStream())) {
			GetFood request;
			try {
				request = (GetFood) inputObject.readObject();
			} catch (ClassNotFoundException e) {
				outputStream.writeObject(new FoodResponse(null, FoodResponse.FAILED_DESERIALIZATION_CODE));
				outputStream.flush();
				return;
			}
			var food = new Food();
			food.setCount(takePortion(request.getFoodCount()));
			
			outputStream.writeObject(new FoodResponse(food, FoodResponse.SUCCESS_CODE));
			
		} catch (IOException e) {
			try {
				outputStream.writeObject(new FoodResponse(null, FoodResponse.SERVER_ERROR_CODE));
			} catch (IOException e1) {
				throw new RuntimeException(e1);
			}
		} finally {
			try {
				outputStream.flush();
				client.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
