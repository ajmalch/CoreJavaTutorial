package com.stream;

import java.util.List;

import static java.util.stream.Collectors.*;


// Inspired by Venkat Subramaniam's talk "LJC Virtual Meetup: Exploring Collectors", similar to this former one: https://www.youtube.com/watch?v=z1eaTv_FASg
// See javadoc for Collectors: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/stream/Collectors.html
// Run me with Java 14 via 'jshell --enable-preview'

public class CollectorsExample {
        public static void main(String[] args) {
                var persons = List.of(
                        new People("Sarah", 14),
                        new People("Venkat", 30),
                        new People("Sarah", 65),
                        new People("Farid", 12));

                // List all persons (mutable or not)
                System.out.println("Mutable List :"+persons.stream()
                        .collect(toList()));

                System.out.println("immutable List :" + persons.stream()
                        .collect(toUnmodifiableList()));

                // Filter
                System.out.println("Filter age below 20 :"+persons.stream()
                        .filter(p -> p.age() < 20)
                        .collect(toList()));

                // Filter and map
                System.out.println("Map to age set:" +persons.stream()
                        .map(People::age)
                        .collect(toSet()));

                // Join
                System.out.println("Joinin :" + persons.stream()
                        .map(People::name)
                        .collect(joining(", ")));

                // Group by
                System.out.println("Group By :" + persons.stream()
                        .collect(groupingBy(People::age)));

                // Sum by
                System.out.println("Sum By :" + persons.stream()
                        .collect(groupingBy(People::name, summingInt(People::age))));


                // Partition by
                System.out.println("Partition By :" + persons.stream()
                        .collect(partitioningBy(p -> p.age() < 18)));

                // Tee (merge collectors)
                final var integerList = persons.stream()
                        .collect(
                                teeing(
                                        filtering(
                                                person -> person.age() < 18,
                                                toList()),
                                        filtering(
                                                person -> person.age() >= 65,
                                                toList()),
                                        (underage, retired) -> List.of(underage.size(), retired.size())));
                System.out.println("Tee (merge collectors) :" +integerList);


        }

}


record People(String name, int age) {}
