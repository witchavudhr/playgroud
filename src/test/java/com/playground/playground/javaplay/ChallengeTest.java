package com.playground.playground.javaplay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChallengeTest {

    @Test
    public void testChallengeOnlyMenu() {
        assertEquals("banana,honey,mango,peach,pineapple,strawberry", Challenge.ingredients("Classic,choco"));
        assertEquals("banana,honey,mango,peach,pineapple,strawberry", Challenge.ingredients("Classic,"));
//        assertEquals("banana,honey,mango,peach,pineapple,strawberry", Challenge.ingredients("Classic"));
    }

    @Test
    public void testChallengeMenuWithCustom() {
        assertEquals("banana,honey,mango,peach,pineapple", Challenge.ingredients("Classic,-strawberry,-peanut"));
        assertEquals("banana,honey,peach,pineapple,strawberry", Challenge.ingredients("Classic,-mango"));
        assertEquals("banana,honey,mango,peach,pineapple,strawberry", Challenge.ingredients("Classic,mango"));
        assertEquals("banana,cherry,chocolate,ice cream,peanut", Challenge.ingredients("Just desserts,ice cream"));
        assertEquals("banana,cherry,chocolate,peanut", Challenge.ingredients("Just desserts,-ice cream"));
    }

    @Test
    public void test3() {
//        assertEquals("banana,honey,mango,peach,pineapple", Challenge.ingredients("Classic,-strawberry,-peanut,-banana,-honey,-mango,-peach"));
        assertThrows(IllegalArgumentException.class, () -> Challenge.ingredients("Classic,-strawberry,-banana,-honey,-mango,-peach,-pineapple"));
    }
}
