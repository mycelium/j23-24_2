package ru.spbstu.lesson.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Dish {
	private static int portions = 500;

	private static int takePortion(int count) {
		if (portions - count > 0) {
			portions -= count;
			System.out.println("Taken: " + count);
			return count;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			ServerSocket server = new ServerSocket(10000);
			while (true) {
				Socket client = server.accept();
				var inputObject = new ObjectInputStream(client.getInputStream());

				var request = (GetFood) inputObject.readObject();

				var response = new Food();
				response.setCount(takePortion(request.getFoodCount()));

				var outputStream = new ObjectOutputStream(client.getOutputStream());
				outputStream.writeObject(response);

				outputStream.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
