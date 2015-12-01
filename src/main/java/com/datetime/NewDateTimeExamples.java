package com.datetime;

import java.time.LocalDate;
import java.time.LocalTime;

public class NewDateTimeExamples {

	public static void main(String[] args) {
		LocalDate today= LocalDate.now();
		System.out.println(today.toString());
		System.out.println(today.getDayOfMonth());
		System.out.println(today.getDayOfWeek());
		System.out.println(today.isLeapYear());
		System.out.println(today.plusDays(12).toString()); 
		
		//LocalTime localTime = LocalTime.now();     //toString() in format 09:57:59.744
		LocalTime localTime = LocalTime.of(12, 20);
		System.out.println(localTime.toString());    //12:20
		System.out.println(localTime.getHour());     //12
		System.out.println(localTime.getMinute());   //20
		System.out.println(localTime.getSecond());   //0
		System.out.println(localTime.MIDNIGHT);      //00:00
		System.out.println(localTime.NOON);          //12:00
	}

}
