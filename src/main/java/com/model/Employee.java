package com.model;

import java.math.BigDecimal;

public class Employee extends Person {

	private BigDecimal salary;
	
	public Employee(String name, Gender sex, int age, BigDecimal salary) {
		super();
		this.setFirstName(name);
		this.setGender(sex);
		this.setAge(age);
		this.salary = salary;
	}
	
	


	public BigDecimal getSalary() {
		return salary;
	}



	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}


	
	@Override
	public String toString() {
		return this.getFirstName();
	}

	
	
	
}
