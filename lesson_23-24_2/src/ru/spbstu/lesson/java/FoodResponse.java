package ru.spbstu.lesson.java;

import java.io.Serializable;

public class FoodResponse implements Serializable {
	public static int SUCCESS_CODE = 200;
	public static int FAILED_DESERIALIZATION_CODE = 400;
	public static int SERVER_ERROR_CODE = 500;
	
	private final Food food;
	
	public Food getFood() {
		return food;
	}

	public int getStatusCode() {
		return statusCode;
	}

	private final int statusCode;

	public FoodResponse(Food food, int statusCode) {
		super();
		this.food = food;
		this.statusCode = statusCode;
	}
	
}
