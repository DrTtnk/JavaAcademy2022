package com.company;

import java.util.stream.IntStream;

public class Exercise2 {
}

class GuessTheOutput {
    // ToDo What is the output of the following code?
    public static void main(String[] args) {
        IntStream.range(0, 1000)
                .filter(i -> i % 2 == 0)
                .map(i -> i * i)
                .forEach(System.out::println);
    }
}