package com.company;

import java.util.Arrays;
import java.util.List;

interface Perimetrable {
    double getPerimeter();
}

interface Areable {
    double getArea();
}

interface Volumeable {
    double getVolume();
}

interface Shape extends Perimetrable, Areable {
}

interface Solid extends Areable, Volumeable {
}

class Rectangle implements Shape {
    public float height;
    public float width;

    Rectangle(float height, float width) {
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        return height * width;
    }

    public double getPerimeter() {
        return 2 * (height + width);
    }
}

class Square implements Shape {
    public float side;

    Square(float side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }
}

class Circle implements Shape {
    public float radius;

    Circle(float radius) {
        this.radius = radius;
    }

    public double getArea() {
        return (float) (Math.PI * radius * radius);
    }

    public double getPerimeter() {
        return 2 * (float) (Math.PI * radius);
    }
}

class Triangle implements Shape {
    public float side1;
    public float side2;
    public float side3;

    Triangle(float side1, float side2, float side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {
        return (side1 + side2 + side3) / 2;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}

class Cube implements Solid {
    public float side;

    Cube(float side) {
        this.side = side;
    }

    public double getArea() {
        return 6 * side * side;
    }

    public double getVolume() {
        return side * side * side;
    }
}

class ShapesInterfacesAndBehaviors {
    public static void main(String[] args) {
        var genericShapes = Arrays.asList(
                new Rectangle(2, 3),
                new Square(4),
                new Circle(5),
                new Triangle(6, 7, 8)
        );

        var totalArea = getTotalArea(genericShapes.stream().map(Areable.class::cast).toList()); // <- casting to ArrayList<Areable>
        var totalPerimeter = getTotalPerimeter(genericShapes.stream().map(Perimetrable.class::cast).toList()); // <- casting to ArrayList<Perimetrable>
        var totalVolume = getTotalVolume(genericShapes.stream().map(Volumeable.class::cast).toList()); // <- casting to ArrayList<Volumeable>
        System.out.println("Total area: " + totalArea);
        System.out.println("Total perimeter: " + totalPerimeter);
        System.out.println("Total volume: " + totalVolume);
    }

    public static double getTotalArea(List<Areable> shape) {
        return shape.stream().mapToDouble(Areable::getArea).sum();
    }

    public static double getTotalPerimeter(List<Perimetrable> shape) {
        return shape.stream().mapToDouble(Perimetrable::getPerimeter).sum();
    }

    public static double getTotalVolume(List<Volumeable> shape) {
        return shape.stream().mapToDouble(Volumeable::getVolume).sum();
    }
}