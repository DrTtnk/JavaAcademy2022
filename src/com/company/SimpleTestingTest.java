package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTestingTest {

    @Test
    void add() {
        assertEquals(3, SimpleTesting.add(1, 2));
        assertEquals(5, SimpleTesting.add(2, 3));
    }

    @Test
    void sort() {
        assertArrayEquals(new int[]{1, 2, 3}, SimpleTesting.sort(new int[]{3, 2, 1}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, SimpleTesting.sort(new int[]{5, 4, 3, 2, 1}));
    }
}