package com.serializaion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Employee extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2982579166412918867L;

	int salary;
	transient Department dept;
	
	public Employee(String name, int age,int salary, Department dept ){
		
		super(name,age);
		this.salary=salary;
		this.dept=dept;
		
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{

		in.defaultReadObject();
		Department department=new Department((String)in.readObject(),in.readLong(),(String)in.readObject());
		this.dept=department;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException{
		
		out.defaultWriteObject();
		out.writeObject(dept.getName());
		out.writeLong(dept.getId());
		out.writeObject(dept.getDescription());
	}
}
