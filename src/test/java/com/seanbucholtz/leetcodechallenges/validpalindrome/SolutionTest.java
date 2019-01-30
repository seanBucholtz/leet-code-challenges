package com.seanbucholtz.leetcodechallenges.validpalindrome;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isPalindrome_1() {
        String input = "A man, a plan, a canal: Panama";
        Solution solution = new Solution();
        assertTrue(solution.isPalindrome(input));
    }

    @Test
    public void isPalindrome_2() {
        String input = "race a car";
        Solution solution = new Solution();
        assertFalse(solution.isPalindrome(input));
    }

    @Test
    public void isPalindrome_3() {
        String input = ".";
        Solution solution = new Solution();
        assertTrue(solution.isPalindrome(input));
    }

    @Test
    public void isPalindrome_4() {
        String input = "";
        Solution solution = new Solution();
        assertTrue(solution.isPalindrome(input));
    }

    @Test
    public void isPalindrome_5() {
        String input = "a.";
        Solution solution = new Solution();
        assertTrue(solution.isPalindrome(input));
    }

    @Test
    public void isPalindrome_6() {
        String input = "a+.";
        Solution solution = new Solution();
        assertTrue(solution.isPalindrome(input));
    }

    @Test
    public void isPalindrome_7() {
        String input = "a+.^";
        Solution solution = new Solution();
        assertTrue(solution.isPalindrome(input));
    }
}