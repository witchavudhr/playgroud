package com.playground.playground.javaplay;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
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
        assertEquals("banana,honey,mango,peach,pineapple,strawberry", challenge.ingredients("Classic,"));
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
        assertThrows(IllegalArgumentException.class, () -> challenge.ingredients("Classic,ice"));
    }

    @Test
    public void test5() {
        assertThrows(IllegalArgumentException.class, () -> challenge.ingredients("test,ice"));
    }

    @Test
    public void test3() {
        assertEquals("pineapple", challenge.ingredients("Classic,-strawberry,-peanut,-banana,-honey,-mango,-peach"));
        assertThrows(IllegalArgumentException.class, () -> challenge.ingredients("Classic,-strawberry,-banana,-honey,-mango,-peach,-pineapple"));
    }

    @Test
    public void test9(){
        Optional<String> opt = Optional.ofNullable(null);
        assertFalse(opt.isPresent());
    }
}
