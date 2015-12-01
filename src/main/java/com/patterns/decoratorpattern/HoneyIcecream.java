package com.patterns.decoratorpattern;

public class HoneyIcecream extends IcecreamDecorator {

	
	public HoneyIcecream(Icecream ice){
				super(ice);
	}
	
	@Override
	public String  makeIcecream() {
		
		return super.makeIcecream()+" + Sweet Honey"; 

	}

}
