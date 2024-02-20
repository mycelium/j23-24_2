package ru.spbstu.lesson.java;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Dish {
	private static int portions;
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10000);
			Socket client = server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
