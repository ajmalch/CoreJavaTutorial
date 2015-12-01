package com.enums.singleton;





public class EnumSingletonTest {
	
	public static void main(String[] args){
		Table t1= Table.INSTANCE;
		Table t2= Table.INSTANCE;
		
		System.out.println("Length and braedth of t1 before updating : " + t1.getLength() + " & " +t1.getBreadth());
		System.out.println("Length and braedth of t2 before updating : " + t2.getLength() + " & " +t2.getBreadth());
		
		t1.setLength(25);
		t1.setBreadth(34);
		
		System.out.println("Length and braedth of t1 after updating t1 : " + t1.getLength() + " & " +t1.getBreadth());
		System.out.println("Length and braedth of t2 after updating t1 : " + t2.getLength() + " & " +t2.getBreadth());
		System.out.println(t1.area());
	}
	

}
