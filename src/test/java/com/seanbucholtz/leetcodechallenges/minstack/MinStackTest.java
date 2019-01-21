package com.seanbucholtz.leetcodechallenges.minstack;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinStackTest {

    @Test
    public void push() {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        assertEquals(3, minStack.size());
    }

    @Test
    public void pop() {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        minStack.pop();

        assertEquals(2, minStack.size());
    }

    @Test
    public void top() {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(-3);
        minStack.push(0);

        assertEquals(0, minStack.top());
    }

    @Test
    public void getMin() {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        assertEquals(-3, minStack.getMin());
    }

    @Test
    public void sequence_1() {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        assertEquals(-3, minStack.getMin());

        minStack.pop();

        assertEquals(0, minStack.top());

        assertEquals(-2, minStack.getMin());
    }
}