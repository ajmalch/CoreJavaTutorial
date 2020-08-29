package com.optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class OptionalTest {

	public static void main(String[] args) {
		Optional<Integer> emptyInteger=Optional.empty();
		Integer value=emptyInteger.orElse(5);
		System.out.println(value);
		
		Optional<Car> carOptional1=Optional.empty();
		Optional<Car> carOptional2=Optional.ofNullable(null);
		Optional<Car> carOptional3=Optional.of(new Car("Honda","Accord",10000));
		Optional<Car> carOptional4=Optional.of(new Car("Hyundai","Accent",5000));

		Function<Optional<Car>, Optional<Car>> cheapCarFunction = car-> car.filter(c->c.getPrice()<8000);

		Optional<Car> cheapOption1=cheapCarFunction.apply(carOptional1);
		Optional<Car> cheapOption2=cheapCarFunction.apply(carOptional2);
		Optional<Car> cheapOption3=cheapCarFunction.apply(carOptional3);
		Optional<Car> cheapOption4=cheapCarFunction.apply(carOptional4);

		Consumer<Optional<Car>> carConsumer = car-> car.ifPresent(c ->System.out.println(c.getMake() + "  " + c.getModel() + " is Cheap") );

		carConsumer.accept(cheapOption1);
		carConsumer.accept(cheapOption2);
		carConsumer.accept(cheapOption3);
		carConsumer.accept(cheapOption4);


		Function<Optional<Car>, Optional<Integer>>  carPrice = carOptional -> carOptional.map(Car::getPrice);

		System.out.println(carPrice.apply(carOptional1).orElse(0));
		System.out.println(carPrice.apply(carOptional2).orElse(0));
		System.out.println(carPrice.apply(carOptional3).orElse(0));
		System.out.println(carPrice.apply(carOptional3).orElse(0));
	}

}
