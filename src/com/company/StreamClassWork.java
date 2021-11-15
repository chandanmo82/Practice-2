package com.company;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamClassWork {
    public static void main(String[] args) {
        String str = "Java Hungry Blog Alive is Awesome";
        try {
            Character ch = findUsingStream(str);
            System.out.println("First non-repeated character- " + ch);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Character findUsingStream(String str){
        Map<Integer, Long> characters = str.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));
        return (char)characters.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .map(entry -> entry.getKey())
                .orElseThrow(()->new RuntimeException("No non-repeating character found"))
                .intValue();
    }
}
