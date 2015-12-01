package com.patterns.decoratorpattern;

public abstract class IcecreamDecorator implements Icecream {

	Icecream ice;
	
	public IcecreamDecorator(Icecream ice){
		
		this.ice=ice;
	}
	
	@Override
	public String  makeIcecream() {
		return ice.makeIcecream();

	}

}
