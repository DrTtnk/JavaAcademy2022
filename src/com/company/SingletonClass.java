package com.company;

import java.util.ArrayList;

class SingletonPerson {
    public String name;
    public String surname;
    public int age;

    static SingletonPerson singletonReference;

    static public SingletonPerson getReference() {
        if(singletonReference != null)
            return singletonReference;

        singletonReference = new SingletonPerson("Ennio", "Annio", 23);
        return singletonReference;
    }

    private SingletonPerson(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}


class Scratch {
    public static void main(String[] args) {
        var person1 = SingletonPerson.getReference();
        var person2 = person1;

        System.out.println(person1.name);

        person1.name = "Mimmo";

        System.out.println(person1.name);
        System.out.println(person2.name);
    }
}