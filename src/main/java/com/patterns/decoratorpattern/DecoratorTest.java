package com.patterns.decoratorpattern;

public class DecoratorTest {
	
	public static void main(String[] args){
		
		Icecream myicecream= new NuttyIcecream(new HoneyIcecream(new SimpleIcecream()));
		System.out.println(myicecream.makeIcecream());
	}

}
