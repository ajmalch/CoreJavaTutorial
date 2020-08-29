package com.patterns.strategypattern;

import java.util.Date;

public class ShoppingCartTest {

	public static void main(String[] args){
		
		Item bag = new Item("Bag_Small",200,1134);
		Item book = new Item("Book",175, 2343);
		
		ShoppingCart mycart=new ShoppingCart();
		
		mycart.addItem(bag);
		mycart.addItem(book);
		
		mycart.purchase(new CreditCardStrategy(1234,"Ajmal",new Date(),1234));
		
		mycart.purchase(new PaypalStrategy("ajmalch@gmail.com","1234"));

		mycart.purchase((amount)->{
			System.out.println(amount + "paid with another method");
		});
	}
}
