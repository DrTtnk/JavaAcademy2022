package com.company;


import java.util.ArrayList;
import java.util.function.Function;

public class MyMapTemplated {

    // region - Before
    public static ArrayList<Integer> mapMeDouble(ArrayList<Integer> elements) {
        var res = new ArrayList<Integer>();
        for (Integer element : elements) res.add(element * 2);
        return res;
    }

    public static ArrayList<Integer> mapMeSquare(ArrayList<Integer> elements) {
        var res = new ArrayList<Integer>();
        for (Integer element : elements) res.add(element * element);
        return res;
    }

    public static ArrayList<String> mapMeHappy(ArrayList<Integer> elements) {
        var res = new ArrayList<String>();
        for (Integer element : elements) res.add(element + " :D");
        return res;
    }
    // endregion

    // region - After
    public static <TIn, TOut> ArrayList<TOut> mapMe(ArrayList<TIn> elements, Function<TIn, TOut> func) {
        var res = new ArrayList<TOut>();
        for (TIn element : elements) res.add(func.apply(element));
        return res;
    }
    // endregion

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");
        strings.add("!");

        for (Integer i : mapMe(numbers, (i1) -> i1)) System.out.println(i);
        System.out.println();

        for (Integer i : mapMe(numbers, (i1) -> i1 * 3)) System.out.println(i);
        System.out.println();

        for (String s : mapMe(strings, (s1) -> s1 + " :D")) System.out.println(s);
        System.out.println();

        for (Integer i : mapMe(strings, String::length)) System.out.println(i);
    }
}



