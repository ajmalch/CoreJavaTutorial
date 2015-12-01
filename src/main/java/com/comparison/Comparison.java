package com.comparison;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comparison {
	
	public static void main(String[] args){
		List<Person> people= new ArrayList<Person>();
		Person p1= new Person("Ajmal",30);
		Person p2= new Person("Shadiya",25);
		Person p3= new Person("Maliha",2);
		Person p4= new Person("Ajmal",5);
		Person p5= new Person("Shabeer",30);
		
		people.add(p1);
		people.add(p2);
		people.add(p3);
		people.add(p4);
		people.add(p5);
		people.add(p1);
		
		System.out.println(people);
		
		//people.sort((a1,a2)->a1.getAge()-(a2.getAge()));
		people.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
		System.out.println(people);
	}
	
	
	
}
