package ru.spbstu.lesson.java;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import ru.spbstu.lesson.java.Philosophers.Philosopher;

public class GreedyPhylosofers {
	public static final long EATING_TIME_MS = 1000;
//	public static final long WAIT_TIME_MS = 2000;

	static class Philosopher extends Thread {
		private static final long THINKING_TIME_MS = 2000;
		Lock left;
		Lock right;
		Boolean isLeft;

		public Philosopher(Lock left, Lock right, Boolean isLeft) {
			this.left = left;
			this.right = right;
			this.isLeft = isLeft;

		}

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {

				try {
					if (isLeft) {
						left.lock();
						right.lock();
					} else {
						right.lock();
						left.lock();
					}
					int count = 0;
					try {
						Socket server = new Socket("127.0.0.1", 10000);
						var request = new GetFood();
						request.setFoodCount((int) (Math.random() * 10));
						request.setName(Thread.currentThread().getName());
						
						
						
						var outputStream = new ObjectOutputStream(server.getOutputStream());
						outputStream.writeObject(request);

						outputStream.flush();

						var inputObject = new ObjectInputStream(server.getInputStream());
						var response = (Food) inputObject.readObject();
						count = response.getCount();

						server.close();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}

					if (count == 0) {
						break;
					}

					Thread.sleep(EATING_TIME_MS);
					System.out.println(Thread.currentThread().getName() + " eats" + count);

				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				} finally {
					right.unlock();
					left.unlock();
				}
				try {
					Thread.sleep(THINKING_TIME_MS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

	public static void main(String[] args) {
		var forks = new Lock[] { new ReentrantLock(), new ReentrantLock(), new ReentrantLock(), new ReentrantLock(),
				new ReentrantLock() };
		var philosophers = List.of(new Philosopher(forks[0], forks[1], true),
				new Philosopher(forks[1], forks[2], false), new Philosopher(forks[2], forks[3], true),
				new Philosopher(forks[3], forks[4], false), new Philosopher(forks[4], forks[0], true));
		philosophers.forEach(Thread::start);
	}
}
