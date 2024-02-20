package ru.spbstu.lesson.java;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class App {
	
	static class Thread2 extends Thread {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	static class Run2 implements Runnable {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		new Thread(()-> {
			System.out.println(Thread.currentThread().getName());
		}, "A").start();
		new Thread2().start();
		new Thread(new Run2()).start();
		var fut = Executors.newSingleThreadExecutor().submit(new Run2());
		CompletableFuture.runAsync(new Run2());
	}
}
