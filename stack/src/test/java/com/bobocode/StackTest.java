package com.bobocode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testCreateStack() {
        Stack<Integer> stack = new StackImpl<>();
    }

    @Test
    public void testPushElement() {
        Stack<Integer> stack = new StackImpl<>();

        stack.push(12);

        assertEquals(1, stack.size());
        assertEquals(12, stack.pop());
    }

    @Test
    public void testOf() {
        Stack<Integer> stack = StackImpl.of(1, 2, 3, 4, 5);

        assertEquals(5, stack.size());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.size());
    }

    @Test
    public void testPopElement() {
        Stack<Integer> stack = new StackImpl<>();
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);

        assertEquals(12, stack.pop());
        assertEquals(4, stack.size());
    }

    @Test
    public void testSize() {
        Stack<Integer> stack = new StackImpl<>();

        stack.push(12);

        assertEquals(1, stack.size());
    }

    @Test
    public void testIsEmpty() {
        Stack<Integer> stack = new StackImpl<>();
        assertTrue(stack.isEmpty());

        stack.push(12);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }
}
