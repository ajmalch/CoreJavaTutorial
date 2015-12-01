package com.patterns.strategypattern;

import java.util.Date;

class CreditCardStrategy implements PaymentStrategy {

	private int creditcrd_num;
	private String name;
	private int code;
	public int getCreditcrd_num() {
		return creditcrd_num;
	}


	public String getName() {
		return name;
	}


	public int getCode() {
		return code;
	}


	public Date getDate() {
		return expiry_date;
	}


	Date expiry_date;
	
	public CreditCardStrategy(int num, String name, Date exp_date, int code){
		this.creditcrd_num=num;
		this.name=name;
		this.expiry_date=exp_date;
		this.code=code;
	}
	
	@Override
	public void pay(int amount) {
		
		System.out.println(amount+ " paid using Credit Card");

	}

}
