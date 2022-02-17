package com.company;

interface Animal {
    void run();
}

abstract class AnimalAbstract implements Animal {
    public abstract void eat();
    public void sleep() { System.out.println("zzz"); }
}

class Dog extends AnimalAbstract {
    public void run() { System.out.println("Dog is running..."); }

    public void eat() { System.out.println("Dog is eating..."); }
}

class Cat extends AnimalAbstract {
    public void run() { System.out.println("Cat is running..."); }

    public void eat() { System.out.println("Cat is eating..."); }
}

class Pigeon extends AnimalAbstract {
    @Override
    public void run() { System.out.println("Pigeon is running..."); }

    public void eat() { System.out.println("Pigeon is eating..."); }
}

class AnimalClassesAndInterfaces {

    public static void makeItRun(AnimalAbstract animal) {
        animal.run();
        animal.eat();
        animal.sleep();
    }

    public static void main(String[] args) {
        // var genericAnimal = new AnimalAbstract(); // <- ERROR: AnimalAbstract is not a concrete class, thus it cannot be instantiated.
        var dog = new Dog();
        var cat = new Cat();
        var pigeon = new Pigeon();

        makeItRun(dog);
        makeItRun(cat);
        makeItRun(pigeon);
    }
}