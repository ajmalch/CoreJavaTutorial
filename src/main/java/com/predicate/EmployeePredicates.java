package com.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.model.Employee;
import com.model.Gender;

public interface EmployeePredicates {

	
	public default Predicate<Employee> isAdultMale(){
		return p->p.getAge()>21 && p.getGender().equals(Gender.MALE);
	}
	
	public default Predicate<Employee> isAdultFemale(){
		return p->p.getAge()>18 && p.getGender().equals(Gender.FEMALE);
	}
	
	public default Predicate<Employee> isAgeMoreThan(Integer age) {
        return p -> p.getAge() > age;
    }
	
	public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate){
		return employees.stream().filter(predicate).collect(Collectors.<Employee>toList());
	}
	
}
