package com.enums;

public enum PayrollDay {
	
	SUNDAY(PayType.WEEKEND),
	MONDAY(PayType.WEEKDAY),TUESDAY(PayType.WEEKDAY),
	WEDNESDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY),
	FRIDAY(PayType.WEEKDAY),
	SATURDAY(PayType.WEEKEND);
	
	
	private final PayType paytype;
	PayrollDay(PayType paytype){
		this.paytype=paytype;
	}

	double pay(double hoursWorked, double payRate){
		return paytype.pay(hoursWorked, payRate);
	}
	
	private static enum PayType{
		WEEKDAY{
			double overtimePay(double hoursWorked, double payRate){
			 return	hoursWorked<HOURS_PER_SHIFT?0:(hoursWorked-HOURS_PER_SHIFT)*payRate*OVERTIME_PERCENTAGE/100;
			}
		},
		WEEKEND{
			double overtimePay(double hoursWorked, double payRate){
				 return hoursWorked*payRate*OVERTIME_PERCENTAGE/50;
				}
			};
		
		private static final int HOURS_PER_SHIFT = 8;
		private static final int OVERTIME_PERCENTAGE = 50;
		abstract double overtimePay(double hoursWorked, double payRate);

		double pay(double hoursWorked, double payRate){
			double basePay=hoursWorked*payRate;
			return basePay+overtimePay(hoursWorked,payRate);
		}
		
	}
}
