package com.enums.singleton;

enum Table {

	INSTANCE(10,20);
	Table(int a, int b){
		length=a;
		breadth=b;
	}
	
	private int length, breadth;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	
	public int area(){
		return length*breadth;
	}
}
