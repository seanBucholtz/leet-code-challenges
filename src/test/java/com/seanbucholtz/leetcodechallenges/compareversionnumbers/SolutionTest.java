package com.seanbucholtz.leetcodechallenges.compareversionnumbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void compareVersion_1() {
        Solution solution = new Solution();
        assertEquals(-1, solution.compareVersion("0.1", "1.1"));
    }

    @Test
    public void compareVersion_2() {
        Solution solution = new Solution();
        assertEquals(0, solution.compareVersion("1.0", "1"));
    }

    @Test
    public void compareVersion_3() {
        Solution solution = new Solution();
        assertEquals(1, solution.compareVersion("1.0.1", "1"));
    }
}