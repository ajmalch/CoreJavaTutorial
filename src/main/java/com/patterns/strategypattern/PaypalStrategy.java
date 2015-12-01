package com.patterns.strategypattern;

class PaypalStrategy implements PaymentStrategy {

	
	String email;
	String password;
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public PaypalStrategy(String email, String password){
		this.email=email;
		this.password=password;
	}
	
	@Override
	public void pay(int amount) {
		System.out.println(amount+" paid using Paypal");

	}

	
}
