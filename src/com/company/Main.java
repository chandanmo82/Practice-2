package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Map<String, String> books = new HashMap<>();
        books.put(
                "978-0201633610", "Design patterns : elements of reusable object-oriented software");
        books.put(
                "978-1617291999", "Java 8 in Action: Lambdas, Streams, and functional-style programming");
        books.put("978-0134685991", "Effective Java");
        Optional<Map.Entry<String,String>> s=books.entrySet().stream().findFirst();
        if(s.isPresent()){
            System.out.println("First Element ="+s.get());

        }
    }
}
