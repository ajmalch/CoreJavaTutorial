package com.comparison;

import java.util.*;

public class ComparisonExample implements Comparator<Person> {

	/**
	 * 
	 */
	private ComparisonExample(){}

    private static ComparisonExample INSTANCE = new ComparisonExample();

    public static void main(String[] args) {

        Set<Person> people=new TreeSet<>();
		
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
		
		System.out.println("The sorted treeset is");
		System.out.println(people);
		List<Person> p_list=new ArrayList<>(people);
		p_list.add(new Person("Ajmal", 30));
		System.out.println("list before comparator sorting");
		System.out.println(p_list);
        p_list.sort(INSTANCE);
        System.out.println("list after comparator sorting");
		System.out.println(p_list);
		Set<Person> people_reverse=new TreeSet<>(Collections.reverseOrder());
		people_reverse.addAll(people);

        System.out.println("List after Java 8 Sorting");
        p_list.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        System.out.println(p_list);

        System.out.println("The reverse sorted treeset is");
        System.out.println(people_reverse);
		
		Set<Person> people_comparator=new TreeSet<>(INSTANCE);
		people_comparator.addAll(people);
		System.out.println("The comparator sorted treeset is");
		System.out.println(people_comparator);
		Set<Person> people_comparator_reverse=new TreeSet<>(Collections.reverseOrder(INSTANCE));
		people_comparator_reverse.addAll(people);
		System.out.println("The comparator reverse sorted treeset is");
		System.out.println(people_comparator_reverse);
	}
	
	
	
	@Override
	public int compare(Person p1, Person p2) {
		if(p1.getAge()-p2.getAge()==0) return p1.getName().compareTo(p2.getName());
		return p1.getAge()-p2.getAge();
	}

}
