package com.seanbucholtz.leetcodechallenges.maxchunkstomakesorted;

import org.junit.Assert;

public class SolutionTest {

    @org.junit.Test
    public void maxChunksToSorted() {
        int[] arr = {2,0,4,6,3,1,7,5,8};
        Solution s = new Solution();
        Assert.assertTrue(s.maxChunksToSorted(arr) == 2);
    }
}