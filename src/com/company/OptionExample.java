package com.company;

import java.util.function.Consumer;
import java.util.function.Function;

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

interface UnaryFunction<TIn, TOut> {
    public TOut apply(TIn in);
}

interface Action<TIn> {
    public void accept(TIn in);
}

class Option<T> {
    private final T value;

    public Option(T value) { this.value = value; }

    public <TOut> Option<TOut> map(Function<T, TOut> fn) { // Same as: public <TOut> Option<TOut> map(UnaryFunction<T, TOut> fn)
        return value != null
                ? new Option<>(fn.apply(value))
                : new Option<>(null);
    }

    public void execute(Consumer<T> fn) { // Same as: public void execute(Action<T> fn)
        if (value != null) fn.accept(value);
    }

    public T getOrDefault(T _default) {
        return value != null ? value : _default;
    }
}

public class OptionExample {

    public static void printName(Person person) {
        System.out.println(person.name);
    }

    public static String nameToUpperCase(Person person) {
        return person.name.toUpperCase();
    }

    public static void main(String[] args) {
        var person = new Option<Person>(null);

        var resultingName = person
                .map(OptionExample::nameToUpperCase)
                .getOrDefault("NO NAME!!!");

        System.out.println(resultingName);
    }
}



