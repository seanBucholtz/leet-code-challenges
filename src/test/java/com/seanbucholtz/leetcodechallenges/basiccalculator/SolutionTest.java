package com.seanbucholtz.leetcodechallenges.basiccalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void calculate_1() {
        Solution solution = new Solution();
        int result = solution.calculate("(1+(4+5+2)-3)+(6+8)");
        int expected = 23;
        assertEquals(expected, result);
    }

    @Test
    public void calculate_2() {
        Solution solution = new Solution();
        int result = solution.calculate("   (  3 ) ");
        int expected = 3;
        assertEquals(expected, result);
    }

    @Test
    public void calculate_3() {
        Solution solution = new Solution();
        int result = solution.calculate("2-(5-6)");
        int expected = 3;
        assertEquals(expected, result);
    }

    @Test
    public void reduceAndEvaluate() {
        Solution solution = new Solution();
        String result = solution.reduceAndSum("(1+(4+5+2)-3)+(6+8)");
        String expected = "23";
        assertEquals(expected, result);
    }

    @Test
    public void evaluate() {
        Solution solution = new Solution();
        String result = solution.sum("-1-2+3-4-5+6");
        String expected = "-3";
        assertEquals(expected, result);
    }
}