package com.patterns.strategypattern;

import java.util.ArrayList;
import java.util.List;

class ShoppingCart { 
	
	private List<Item> cart;
	
	public ShoppingCart(){
		
		cart= new ArrayList<Item>();
	}

	public List<Item> getCart() {
		return cart;
	}

	public void addItem(Item item){
		cart.add(item);
	}
	
	public int calculateTotal(){
		int total=0;
		for(Item item:cart){
			total+=item.getPrice();
		}
		return total;
	}
	
	public void purchase(PaymentStrategy strategy ){
		
		strategy.pay(this.calculateTotal());
	}
}
