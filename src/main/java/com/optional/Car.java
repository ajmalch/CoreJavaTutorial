package com.optional;

public class Car {
	private String make;
	private String model;
	private int price;
	public Car(String make, String model, int price) {
		super();
		this.make = make;
		this.model = model;
		this.price = price;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
