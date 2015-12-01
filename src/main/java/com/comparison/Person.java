package com.comparison;

public class Person implements Comparable<Person>{

	private String name;
	private int age;
	
	public Person(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}



	public int getAge() {
		return age;
	}
	
	@Override
	public int compareTo(Person o){
		if(this.name.compareTo(o.name)==0) return this.age-o.age ;	
		return this.name.compareTo(o.name);		
	}

	@Override
	public String toString() {
		return "name=" + name + " age=" + age ;
	}
	
}
