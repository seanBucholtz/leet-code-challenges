package com.seanbucholtz.leetcodechallenges.primepalindrome;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void primePalindrome_1() {
        int input = 13;
        int expectedOutput = 101;

        Solution s = new Solution();

        Assert.assertTrue(s.primePalindrome(input) == expectedOutput);
    }

    @Test
    public void primePalindrome_2() {
        int input = 1;
        int expectedOutput = 2;

        Solution s = new Solution();

        Assert.assertTrue(s.primePalindrome(input) == expectedOutput);
    }

    @Test
    public void primePalindrome_3() {
        int input = 9989900;
        int expectedOutput = 100030001;

        Solution s = new Solution();

        Assert.assertTrue(s.primePalindrome(input) == expectedOutput);
    }
}