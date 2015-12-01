package com.enums;

public class TestPayrollDay {

	public static void main(String[] args) {
		
		final double payRate=12.52;
		PayrollDay monday=PayrollDay.MONDAY;
		PayrollDay sunday=PayrollDay.SUNDAY;
		
		System.out.println("Monday's payment for 10 hours: "+monday.pay(10, payRate) );
		System.out.println("Sunday's payment for 10 hours :"+sunday.pay(10, payRate) );
		System.out.println("Monday's payment for 5 hours :"+monday.pay(5, payRate) );
		System.out.println("Sunday's payment for 5 hours :"+sunday.pay(5, payRate) );
	}

}
