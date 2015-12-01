package com.patterns.strategypattern;

class Item {

private String name;
private int price;
private final int code;

public Item(String name, int price, int code){
	this.name=name;
	this.price=price;
	this.code=code;
}

public void setName(String name) {
	this.name = name;
}

public void setPrice(int price) {
	this.price = price;
}

public String getName() {
	return name;
}

public int getPrice() {
	return price;
}

public int getCode() {
	return code;
}

	
}
