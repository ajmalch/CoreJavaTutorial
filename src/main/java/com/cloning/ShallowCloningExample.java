package com.cloning;

public class ShallowCloningExample  {
	
	
	public static void main( String[] args){
		
		Department dept1= new Department("HR", 100001, " HR Department ");
		
		try {
			Department dept2=dept1.clone();
			if(dept2!=dept1)System.out.println("Shallow cloning completed suceccfully : "+dept2.getDescription());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
