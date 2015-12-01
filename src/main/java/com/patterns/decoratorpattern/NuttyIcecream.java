package com.patterns.decoratorpattern;

public class NuttyIcecream extends IcecreamDecorator {
	
	public NuttyIcecream(Icecream ice){
		super(ice);
}

@Override
public String  makeIcecream() {

return super.makeIcecream()+" + Tasty Nuts"; 

}

}
