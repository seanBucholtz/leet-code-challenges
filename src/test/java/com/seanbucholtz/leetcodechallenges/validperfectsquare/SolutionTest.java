package com.seanbucholtz.leetcodechallenges.validperfectsquare;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isPerfectSquare() {
        Solution solution = new Solution();
        int target = 1;
        assertTrue(solution.isPerfectSquare(target));
    }
}