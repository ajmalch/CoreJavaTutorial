package com.patterns.builderpattern;

public class BulderExample {

	public static void main(String[] args) {
	
		NutritionFacts cocaCola = new NutritionFacts.BuilderClass(240, 8).
				calories(100).sodium(35).carbohydrate(27).build();
		System.out.println(cocaCola.getCarbohydrate());
		NutritionFacts pepsi = new NutritionFacts.BuilderClass(240, 8).
				calories(100).sodium(35).carbohydrate(43).build();
		System.out.println(pepsi.getCarbohydrate());
		
	}

}
