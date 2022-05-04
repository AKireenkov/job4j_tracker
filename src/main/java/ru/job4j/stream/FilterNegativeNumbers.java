package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, 2, 4, -6, 3, -1, -4);
        List<Integer> positive = numbers.stream().filter(el -> el > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}