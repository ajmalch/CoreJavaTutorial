package com.predicate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.model.Employee;
import com.model.Gender;



public class TestEmployeePredicates implements EmployeePredicates{

	public static void main(String[] args) {
		Employee e1 = new Employee("Rick",Gender.MALE,50,new BigDecimal(12235.65));
        Employee e2 = new Employee("Ajmal",Gender.MALE,30,new BigDecimal(12235.65));
        Employee e3 = new Employee("Frank",Gender.MALE,19,new BigDecimal(12235.65));
        Employee e4 = new Employee("Ranju",Gender.MALE,45,new BigDecimal(12235.65));
        Employee e5 = new Employee("Maliha",Gender.FEMALE,3,new BigDecimal(12235.65));
        Employee e6 = new Employee("Shadiya",Gender.FEMALE,26,new BigDecimal(12235.65));
        Employee e7 = new Employee("Joe",Gender.MALE,5,new BigDecimal(12235.65));
        Employee e8 = new Employee("Erwin",Gender.MALE,35,new BigDecimal(12235.65));
        Employee e9 = new Employee("Michele",Gender.FEMALE,50,new BigDecimal(12235.65));
        
        
        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9}));
        
        TestEmployeePredicates test=new TestEmployeePredicates();
        System.out.println(EmployeePredicates.filterEmployees(employees,test.isAdultMale()));
        System.out.println(EmployeePredicates.filterEmployees(employees,test.isAdultFemale()));
        System.out.println(EmployeePredicates.filterEmployees(employees,test.isAgeMoreThan(30)));
        
	}

}
