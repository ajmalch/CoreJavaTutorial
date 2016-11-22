package com.mapreduce;

import com.model.Employee;
import com.model.Gender;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MapReduceExample {

	public static void main(String[] args) {

		List<Employee> users=Arrays.asList(new Employee("Ajmal", Gender.MALE,30, new BigDecimal(50003.42)),
		new Employee("Safa", Gender.FEMALE,30, new BigDecimal(54003.42)),
		new Employee("Shadiya", Gender.FEMALE,30, new BigDecimal(2003.42)),
		new Employee("Maliha", Gender.FEMALE,10, new BigDecimal(100003.42)),
		new Employee("Arun", Gender.MALE,3, new BigDecimal(423403.42)),
		new Employee("John", Gender.MALE,45, new BigDecimal(50003.44)),
		new Employee("Fameel", Gender.MALE,48, new BigDecimal(50003.42)),
		new Employee("Mary", Gender.FEMALE,30, new BigDecimal(1233.00)),
		new Employee("Frank", Gender.MALE,20, new BigDecimal(5002)),
		new Employee("Ansiya", Gender.FEMALE,23, new BigDecimal(1246789.2)),
		new Employee("Manoj", Gender.MALE,42, new BigDecimal(1234.42)),
		new Employee("Joseph", Gender.MALE,33, new BigDecimal(456742)),
		new Employee("Sonu", Gender.MALE,31, new BigDecimal(34242)));
		

		Supplier<Stream<Employee>> matureMenStream = (()->
			users.parallelStream()
					.filter(male->male.getGender().equals(Gender.MALE)&&
							male.getAge()>20));

        double male_average=matureMenStream.get()
        		.mapToDouble(s->s.getSalary().doubleValue()).average().getAsDouble();

		System.out.println("Average Salary of Men with age 20 and above is : " +male_average);
	}

}
