package com.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoundsInGenerics {

	public static void main(String[] args) {

		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		Set<Integer> set3 = new HashSet<>();
		Set<Object> set4= new HashSet<>();
		
		set1.add("Ajmal");
		set1.add("Ravi");
		set1.add("Arun");
		set1.add("Deepak");
		set1.add("Shafi");
		set1.add("John");

		set2.add("Ravi");
		set2.add("Arun");
		set2.add("Rani");
		set2.add("Gokul");
		set2.add("Ram");

		set3.add(3);
		set3.add(6);
		set3.add(75);

		set4.addAll(set2);
		System.out.println(numElementsInCommon(set1, set2));
		System.out.println(numElementsInCommon(set1, set3));
		
		System.out.println(numElementsInCommon(set1, set4));

		System.out.println(union(set1, set2));
		// System.out.println(union(set1,set3));//compile time error as set1 and set3 are of different types
		List<String> myList = new ArrayList<>();
		myList.addAll(set1);
		List<?> secList = myList;
		// secList.add("s");
		System.out.println(secList);
		
		List<Object> mylist= new ArrayList<>();
		mylist.add(123);
		mylist.add("12");
		
		//@SuppressWarnings("unused")
		List<?> seclist = new ArrayList<>();
		seclist = mylist;
		swap(seclist,0,1);
		System.out.println(seclist);
		swap2(seclist,0,1);
		System.out.println(seclist);
	//	seclist.add("sdf");
		
		@SuppressWarnings("unused")
		List<?> thilist = new ArrayList<>();
		thilist = mylist;
	//	thilist.add("123");
		
		//List<String>[] stringLists = new List<String>[1];
		List<?>[] stringLists = new List<?>[3]; 
		List<Integer> intList = Arrays.asList(42,23); 
		Object[] objects = stringLists; 
		objects[0] = intList; 
		objects[1] = intList;
		//stringLists[0].add(1);
		//System.out.println(objects[1].getClass()+" "+stringLists.getClass());
		Integer s = (Integer)stringLists[0].get(0);
		System.out.println(s);
	}

	
	public static  int numElementsInCommon(Set<?> s1, Set<?> s2) {
		int result = 0;
		//s2.addAll(s1); //this won't work with unbounded type
		for (Object o1 : s1)
			if (s2.contains(o1))
				result++;
		return result;
	}

	public static void swap(List<?> list, int i, int j) {
		//list.set(i, list.set(j, list.get(i)));
		swapHelper(list, i, j);
	}
	private static <E> void swapHelper(List<E> list, int i, int j) {
		
		list.set(i, list.set(j, list.get(i)));
	}
	
	public static <E> void swap2(List<E> list, int i, int j) {
		list.set(i, list.set(j, list.get(i)));
	}
	public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2); //this won't work with unbounded types
		return result;
	}
	

}
