package com.optional;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalTest {

	public static void main(String[] args) {
		Optional<Integer> emptyinteger=Optional.empty();
		//emptyinteger=Optional.of(12);
		Integer value=emptyinteger.orElse(5);
		//System.out.println(emptyinteger.get());
		System.out.println(value);
		
		Optional<Car> carOptional1=Optional.empty();
		Optional<Car> carOptional2=Optional.ofNullable(null);
		Optional<Car> carOptional3=Optional.of(new Car("Honda","Accord",10000));
		Optional<Car> carOptional4=Optional.of(new Car("Hyundai","Accent",5000));
		Optional<Car> cheapOtption1=carOptional1.filter(p->p.getPrice()<8000);
		Optional<Car> cheapOtption2=carOptional2.filter(p->p.getPrice()<8000);
		Optional<Car> cheapOtption3=carOptional3.filter(p->p.getPrice()<8000);
		Optional<Car> cheapOtption4=carOptional4.filter(p->p.getPrice()<8000);
		if(cheapOtption1.isPresent()) System.out.println(cheapOtption1.get().getMake()+ "  " + cheapOtption1.get().getModel() + " is Cheap");
		if(cheapOtption2.isPresent()) System.out.println(cheapOtption2.get().getMake()+ "  " + cheapOtption2.get().getModel() + " is Cheap");
		if(cheapOtption3.isPresent()) System.out.println(cheapOtption3.get().getMake()+ "  " + cheapOtption3.get().getModel() + " is Cheap");
		if(cheapOtption4.isPresent()) System.out.println(cheapOtption4.get().getMake()+ "  " + cheapOtption4.get().getModel() + " is Cheap");
		
		Optional<Integer> cheapCar1=carOptional1.map(c->c.getPrice());
		Optional<Integer> cheapCar2=carOptional2.map(c->c.getPrice());
		Optional<Integer> cheapCar3=carOptional3.map(c->c.getPrice());
		Optional<Integer> cheapCar4=carOptional4.map(c->c.getPrice());
		
		System.out.println(cheapCar1.orElse(0));
		System.out.println(cheapCar2.orElse(0));
		System.out.println(cheapCar3.orElse(0));
		System.out.println(cheapCar4.orElse(0));
	}

}
