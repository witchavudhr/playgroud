package com.playground.playground.javaplay;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Challenge2Test {
    @Test
    public void test1() {
        assertTrue(DiskSpace.isWritable(1, 1, new HashSet<>()));
    }

    @Test
    public void test2() {
        assertFalse(DiskSpace.isWritable(1, 1, new HashSet<>(Arrays.asList(1))));
    }

    @Test
    public void test3() {
        assertFalse(DiskSpace.isWritable(1, 2, new HashSet<>()));
    }

    @Test
    public void test4() {
        assertFalse(DiskSpace.isWritable(5, 2, new HashSet<>(Arrays.asList(1, 2, 3, 4))));
    }

    @Test
    public void test5() {
        assertTrue(DiskSpace.isWritable(1000000, 100000, new HashSet<>(Arrays.asList(200000))));
    }

    @Test
    public void test6() {
        assertTrue(DiskSpace.isWritable(1000000, 100000, new HashSet<>(Arrays.asList(90000, 180000, 270000, 360000))));
    }

    @Test
    public void test7() {
        assertTrue(DiskSpace.isWritable(10, 6, new HashSet<>(Arrays.asList(1, 8))));
    }
}
