package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoopsToStreams {
    public static void main(String[] str) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, -2, 3, 4, -5, 6, 7, 20, -9, 10, -14, 12, 0, -14, 15, 16, -17, 18, 19, 20));

// ---> boolean isThereAnyNegative = numbers.stream().anyMatch(n -> n < 0);
        boolean isThereAnyNegative = false;
        for (Integer n : numbers) {
            if (n < 0) {
                isThereAnyNegative = true;
                break;
            }
        }

// ---> boolean areAllPositive = numbers.stream().allMatch(n -> n > 0);
        boolean areAllPositive = true;
        for (Integer n : numbers) {
            if (n < 0) {
                areAllPositive = false;
                break;
            }
        }

// ---> int sum = numbers.stream().mapToInt(n -> n).sum();
        int sum = 0;
        for (Integer n : numbers) {
            sum += n;
        }

// ---> int numberOfEvens = numbers.stream().mapToInt(n -> n).filter(n -> n % 2 == 0).count();
        int numberOfEvens = 0;
        for (Integer n : numbers) {
            if (n % 2 == 0) {
                numberOfEvens++;
            }
        }

// ---> int max = numbers.stream().mapToInt(n -> n).max().orElse(Integer.MIN_VALUE);
        int max = Integer.MIN_VALUE;
        for (Integer n : numbers) {
            if (n > max) {
                max = n;
            }
        }

// ---> int min = numbers.stream().mapToInt(n -> n).min().orElse(Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE;
        for (Integer n : numbers) {
            if (n < min) {
                min = n;
            }
        }

// ---> List<String> eachToString = numbers.stream().map(String::valueOf).toList();
        List<String> eachToString = new ArrayList<>();
        for (Integer n : numbers) {
            eachToString.add(String.valueOf(n));
        }

// ---> List<Integer> repeatedByAbsoluteValue = numbers.stream()
//                .flatMap(n -> IntStream.range(0, Math.abs(n)).mapToObj(__ -> n))
//                .toList();
        List<Integer> repeatedByAbsoluteValue = new ArrayList<>();
        for (Integer n : numbers) {
            for (int i = 0; i < Math.abs(n); i++) {
                repeatedByAbsoluteValue.add(n);
            }
        }

// ---> List<Integer> sorted = numbers.stream().sorted().toList();
        List<Integer> sorted = new ArrayList<>(numbers);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i) > sorted.get(j)) {
                    int temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }

// ---> List<Integer> uniques = numbers.stream().distinct().toList();
        List<Integer> uniques = new ArrayList<>();
        for (Integer n : numbers) {
            if (!uniques.contains(n)) {
                uniques.add(n);
            }
        }

// ---> List<Integer> reverseSorted = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        List<Integer> reverseSorted = new ArrayList<>(numbers);
        for (int i = 0; i < reverseSorted.size() - 1; i++) {
            for (int j = i + 1; j < reverseSorted.size(); j++) {
                if (reverseSorted.get(i) < reverseSorted.get(j)) {
                    int temp = reverseSorted.get(i);
                    reverseSorted.set(i, reverseSorted.get(j));
                    reverseSorted.set(j, temp);
                }
            }
        }

// ---> List<Integer> evens = numbers.stream().filter(n -> n % 2 == 0).toList();
        List<Integer> evens = new ArrayList<>();
        for (Integer n : numbers) {
            if (n % 2 == 0) {
                evens.add(n);
            }
        }

// ---> List<Integer> droppedBeforeZero = numbers.stream().dropWhile(n -> n == 0).toList();
        List<Integer> droppedBeforeZero = new ArrayList<>();
        boolean isDropped = false;
        for (Integer n : numbers) {
            if (n == 0) {
                isDropped = true;
            }
            if (!isDropped) {
                droppedBeforeZero.add(n);
            }
        }

// ---> List<Integer> droppedAfterZero = numbers.stream().dropWhile(n -> n != 0).toList();
        List<Integer> droppedAfterZero = new ArrayList<>();
        boolean isDroppedAfterZero = false;
        for (Integer n : numbers) {
            if (n == 0) {
                isDroppedAfterZero = true;
            }
            if (isDroppedAfterZero) {
                droppedAfterZero.add(n);
            }
        }

// ---> float sumOfInverse = numbers.stream().filter(n -> n != 0).map(n -> (float)n).reduce((acc, x) -> acc + 1.0f / x).orElse(0f);
        float sumOfInverse = 0;
        for (Integer n : numbers) {
            if (n != 0) {
                sumOfInverse += 1.0f / n;
            }
        }


        System.out.println("isThereAnyNegative: " + isThereAnyNegative);
        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("eachToString: " + Arrays.toString(eachToString.toArray()));
        System.out.println("repeatedByAbsoluteValue: " + Arrays.toString(repeatedByAbsoluteValue.toArray()));
        System.out.println("sorted: " + Arrays.toString(sorted.toArray()));
        System.out.println("uniques: " + Arrays.toString(uniques.toArray()));
        System.out.println("reverseSorted: " + Arrays.toString(reverseSorted.toArray()));
        System.out.println("evens: " + Arrays.toString(evens.toArray()));
        System.out.println("droppedBeforeZero: " + Arrays.toString(droppedBeforeZero.toArray()));
        System.out.println("droppedAfterZero: " + Arrays.toString(droppedAfterZero.toArray()));
        System.out.println("sumOfInverse: " + sumOfInverse);
    }
}
