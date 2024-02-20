package ru.spbstu.lesson.java;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosophers {
	
	public static final long EATING_TIME_MS = 1000;
	public static final long WAIT_TIME_MS = 2000;
	

	static class Philosopher extends Thread {
		Lock left;
		Lock right;
		public Philosopher(Lock left, Lock right) {
			this.left = left;
			this.right = right;
		}
		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				left.lock();
				try {
					if (!right.tryLock(WAIT_TIME_MS, TimeUnit.MILLISECONDS)) {
						left.unlock();
						continue;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					left.unlock();
					break;
				}
				try {
					Thread.sleep(EATING_TIME_MS);
					System.out.println(Thread.currentThread().getName() + " eats");
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				} finally {
					right.unlock();
					left.unlock();	
				}
			}
		}
	}
	
	public static void main(String[] args) {
		var forks = new Lock[] {
				new ReentrantLock(),
				new ReentrantLock(),
				new ReentrantLock(),
				new ReentrantLock(),
				new ReentrantLock()
		};
		var philosophers = List.of(
				new Philosopher(forks[0], forks[1]),
				new Philosopher(forks[1], forks[2]),
				new Philosopher(forks[2], forks[3]),
				new Philosopher(forks[3], forks[4]),
				new Philosopher(forks[4], forks[0])
				);
		philosophers.forEach(Thread::start);
	}
}
