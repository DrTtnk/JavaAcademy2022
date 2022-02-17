package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Exercises {
    // ToDo CodeWars kata: https://www.codewars.com/kata/5672a98bdbdd995fad00000f
    // ToDo CodeWars kata: https://www.codewars.com/kata/5556282156230d0e5e000089
    // ToDo CodeWars kata: https://www.codewars.com/kata/5b39e91ee7a2c103300018b3 <- Hint: two pointers

    // region - ToDo Convert these three ugly filters in a single, generic "filterMe"

    public static <T> ArrayList<T> filterMe(ArrayList<T> list, Predicate<T> condition){ // <- Solution with generic
        var res = new ArrayList<T>();
        for (T t : list) if (condition.test(t)) res.add(t);
        return res;
    }

    public static ArrayList<Integer> filterEven(ArrayList<Integer> list) {
        var res = new ArrayList<Integer>();
        for (Integer integer : list) if (integer % 2 == 0) res.add(integer);
        return res;
    }

    public static ArrayList<Integer> filterOdd(ArrayList<Integer> list) {
        var res = new ArrayList<Integer>();
        for (Integer integer : list) if (integer % 2 == 1) res.add(integer);
        return res;
    }

    public static ArrayList<Integer> filterNegative(ArrayList<Integer> list) {
        var res = new ArrayList<Integer>();
        for (Integer integer : list) if (integer < 0) res.add(integer);
        return res;
    }
    // endregion

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15));

        // Made with the old-fashioned way
        for (var i : filterEven(numbers))     System.out.println(i); // <- 2, 4, 6, 8, 10, -12, -14
        for (var i : filterOdd(numbers))      System.out.println(i); // <- 1, 3, 5, 7, 9, -11, -13, -15
        for (var i : filterNegative(numbers)) System.out.println(i); // <- -11, -12, -13, -14, -15

        // Made with the new custom way
        for (var i : filterMe(numbers, x -> x % 2 == 0)) System.out.println(i); // <- 2, 4, 6, 8, 10, -12, -14
        for (var i : filterMe(numbers, x -> x % 2 == 1)) System.out.println(i); // <- 1, 3, 5, 7, 9, -11, -13, -15
        for (var i : filterMe(numbers, x -> x < 0))      System.out.println(i); // <- -11, -12, -13, -14, -15

        // Made with the stream way
        numbers.stream().filter(x -> x % 2 == 0).forEach(System.out::println); // <- 2, 4, 6, 8, 10, -12, -14
        numbers.stream().filter(x -> x % 2 == 1).forEach(System.out::println); // <- 1, 3, 5, 7, 9, -11, -13, -15
        numbers.stream().filter(x -> x < 0).forEach(System.out::println);      // <- -11, -12, -13, -14, -15
    }
}
