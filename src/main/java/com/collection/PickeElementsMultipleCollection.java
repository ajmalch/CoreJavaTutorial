package com.collection;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PickeElementsMultipleCollection {
	
	
	final List<String> friends =
	Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
	final List<String> comrades =
	Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
	final List<String> editors =
	Arrays.asList("Brian", "Jackie", "John", "Mike");
			
	final Function<String, Predicate<String>> startsWithletter;

	final Function<String, Predicate<String>> containsWord;

	{
		containsWord = word -> name -> name.contains(word);
		startsWithletter = letter -> name -> name.startsWith(letter);
	}

	public static void main(String[] args){
		PickeElementsMultipleCollection sample= new PickeElementsMultipleCollection();
		System.out.println(sample.friends.stream().filter(sample.startsWithletter.apply("N")).count());
		System.out.println(sample.comrades.stream().filter(sample.startsWithletter.apply("M")).count());
		System.out.println(sample.editors.stream().filter(sample.containsWord.apply("J")).count());
	}
}
