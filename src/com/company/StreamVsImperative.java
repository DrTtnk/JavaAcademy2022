package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.Function;
import java.util.function.Predicate;

class StreamVsImperative {
     // Problem:
     // Given a complex object, aggregate all the values of the field data
     // into a single array, such that the field key is divisible by 2 and is
     // included in the set of allowed values, defined in the vector "allowed",
     // and multiply them by 2, taken only once
     // And order them by key

    public static class Data {
        public int key;
        public String value;

        public Data(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class ComplexData {
        public Data[] data;

        public ComplexData(Data[] data) {
            this.data = data;
        }
    }

    public static class Result {
        public int key;
        public Data data;

        Result(int key, Data data) {
            this.key = key;
            this.data = data;
        }
    }

    final static int[] ALLOWED = {9, 8, 10, 12, 14};

    /** Old fashion imperative version */
    public static Result[] convertDataImperative(ComplexData[] complexData) {
        ArrayList<Result> res = new ArrayList<>();
        for (int i = 0; i < complexData.length; i++) {
            for (int j = 0; j < complexData[i].data.length; j++) {
                boolean flag = false;
                for (int k = 0; k < ALLOWED.length; k++) {
                    if (ALLOWED[k] == complexData[i].data[j].key) {
                        flag = true;
                    }
                }
                if (complexData[i].data[j].key % 2 == 0 && flag) {
                    boolean isAlreadyPresent = false;
                    for (int k = 0; k < res.size(); k++) {
                        if (res.get(k).key / 2 == complexData[i].data[j].key) {
                            isAlreadyPresent = true;
                        }
                    }
                    if (!isAlreadyPresent) {
                        Data el = complexData[i].data[j];
                        res.add(new Result(el.key * 2, el));
                    }
                }
            }
            for (int j = res.size() - 1; j > 0; j--) {
                if (res.get(j - 1).key > res.get(j).key) {
                    Result tmp = res.get(j);
                    res.set(j, res.get(j - 1));
                    res.set(j - 1, tmp);
                }

            }
        }
        return res.toArray(new Result[0]);
    }

    private static <T> Predicate<T> distinctBy(Function<? super T, ?> keyExtractor) {
        var seen = new HashSet<>();
        return t -> seen.add(keyExtractor.apply(t)); // <- add returns false if already present, true otherwise
    }

    /** New stream version */
    public static Result[] convertDataStream(ComplexData[] complexData) {
        return Arrays.stream(complexData)
                .flatMap(x -> Arrays.stream(x.data))
                .filter(x -> Arrays.stream(ALLOWED).anyMatch(y -> y == x.key))
                .filter(x -> x.key % 2 == 0)
                .map(x -> new Result(x.key * 2, x))
                .filter(distinctBy(x -> x.key))
                .sorted(Comparator.comparingInt(x -> x.key))
                .toArray(Result[]::new);
    }

    public static void main(String[] args) {

        ComplexData[] complexData = new ComplexData[]{
                new ComplexData(new Data[]{new Data(9, "John"), new Data(10, "Jane"), new Data(12, "Mimmo")}),
                new ComplexData(new Data[]{new Data(8, "John"), new Data(10, "Jane"), new Data(14, "Mimmo")}),
                new ComplexData(new Data[]{new Data(9, "John"), new Data(10, "Jane"), new Data(12, "Mimmo")})
        };

        for (Result re : convertDataImperative(complexData))
            System.out.println(re.key + " " + re.data.value);

        System.out.println("\n");

        for (Result re : convertDataStream(complexData))
            System.out.println(re.key + " " + re.data.value);
    }
}