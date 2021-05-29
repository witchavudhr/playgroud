package com.playground.playground.javaplay;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
class SayHelloTests {

    // These example test cases are editable, feel free to add
    // your own tests to debug your code.

    @Test
    public void shouldSayHello() {
        assertEquals("Hello, Qualified!", Challenge.sayHello("Qualified"));
    }
}