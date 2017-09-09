package com.closure;

import java.util.function.Supplier;

public class ClosureExample {

	public static void main(String[] args) {
		Supplier<Supplier<String>> counterSupplier = () ->{
			int count[]= {0};
			return () -> {
				count[0] ++;
				return "Current count is " + count[0] ;
			};
		};
		
		Supplier<String> firstCounter = counterSupplier.get();
		System.out.println(firstCounter.get());
		System.out.println(firstCounter.get());
		
		Supplier<String> secondCounter = counterSupplier.get();
		System.out.println(secondCounter.get());
	}
	
}
