package com.seanbucholtz.leetcodechallenges.replacespace;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void replaceSpaces_0() {
        Solution s = new Solution();
        String input = "test test test    ";
        assertEquals("test%20test%20test", s.replaceSpaces(input.toCharArray(), 14));
    }

    @Test
    public void replaceSpaces_1() {
        Solution s = new Solution();
        String input = "   test test test   ";
        assertEquals("test%20test%20test", s.replaceSpaces(input.toCharArray(), 14));
    }
}