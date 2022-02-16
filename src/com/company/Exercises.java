package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercises {
    // ToDo CodeWars kata: https://www.codewars.com/kata/5672a98bdbdd995fad00000f
    // ToDo CodeWars kata: https://www.codewars.com/kata/5556282156230d0e5e000089
    // ToDo CodeWars kata: https://www.codewars.com/kata/5b39e91ee7a2c103300018b3 <- Hint: two pointers

    // region - ToDo Convert these three ugly filters in a single, generic "filterMe"
    public static ArrayList<Integer> filterEven(ArrayList<Integer> list) {
        var res = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                res.add(list.get(i));
            }
        }
        return res;
    }

    public static ArrayList<Integer> filterOdd(ArrayList<Integer> list) {
        var res = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 1) {
                res.add(list.get(i));
            }
        }
        return res;
    }

    public static ArrayList<Integer> filterNegative(ArrayList<Integer> list) {
        var res = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0) {
                res.add(list.get(i));
            }
        }
        return res;
    }
    // endregion

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15));

        for (var i : filterEven(numbers))     System.out.println(i); // <- 2, 4, 6, 8, 10, -12, -14
        for (var i : filterOdd(numbers))      System.out.println(i); // <- 1, 3, 5, 7, 9, -11, -13, -15
        for (var i : filterNegative(numbers)) System.out.println(i); // <- -11, -12, -13, -14, -15
    }
}



