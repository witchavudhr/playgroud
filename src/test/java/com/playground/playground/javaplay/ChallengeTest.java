package com.playground.playground.javaplay;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChallengeTest {

    private Challenge challenge;

    @BeforeEach
    public void setup(){
        challenge = new Challenge();
    }

    @Test
    public void testChallengeOnlyMenu() {
        assertEquals("banana,honey,mango,peach,pineapple,strawberry", challenge.ingredients("Classic,choco"));
        assertEquals("banana,honey,mango,peach,pineapple,strawberry", challenge.ingredients("Classic,"));
//        assertEquals("banana,honey,mango,peach,pineapple,strawberry", Challenge.ingredients("Classic"));
    }

    @Test
    public void testChallengeMenuWithCustom() {
        assertEquals("banana,honey,mango,peach,pineapple", challenge.ingredients("Classic,-strawberry,-peanut"));
        assertEquals("banana,honey,peach,pineapple,strawberry", challenge.ingredients("Classic,-mango"));
        assertEquals("banana,honey,mango,peach,pineapple,strawberry", challenge.ingredients("Classic,mango"));
        assertEquals("banana,cherry,chocolate,ice cream,peanut", challenge.ingredients("Just desserts,ice cream"));
        assertEquals("banana,cherry,chocolate,peanut", challenge.ingredients("Just desserts,-ice cream"));
    }

    @Test
    public void test4() {
        assertEquals(new HashSet<>(Arrays.asList(1, 2)), challenge.uniqNumber());
    }

    @Test
    public void test5() {
        assertEquals(Arrays.asList(1, 2, 5, 8, 10), challenge.streamPlay());
    }


    @Test
    public void test3() {
//        assertEquals("banana,honey,mango,peach,pineapple", Challenge.ingredients("Classic,-strawberry,-peanut,-banana,-honey,-mango,-peach"));
        assertThrows(IllegalArgumentException.class, () -> challenge.ingredients("Classic,-strawberry,-banana,-honey,-mango,-peach,-pineapple"));
    }
}
