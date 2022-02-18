package com.company;

public class SimpleTesting {
    // add
    public static int add(int a, int b) {
        return a + b;
    }

    public static int[] sort(int[] a) {
        var sorted = new int[a.length];
        System.arraycopy(a, 0, sorted, 0, a.length);

        for (int i = 0; i < sorted.length; i++) {
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[i] > sorted[j]) {
                    var temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        return sorted;
    }
}
