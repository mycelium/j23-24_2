package ru.spbstu.lesson.java;

import java.io.Serializable;

public class GetFood implements Serializable {
	private String name;
	private int foodCount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	
	
}
