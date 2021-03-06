package com.seanbucholtz.leetcodechallenges.twosum;

/**
 * 1. Two Sum
 */
class Solution {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * @param nums  an array of integers
     * @param target the target sum
     * @return the two indices of the integers which sum to the target
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 1;
        boolean found = false;
        for(; i < nums.length; i++) {
            int x = nums[i];
            j = i + 1;
            for(; j < nums.length; j++) {
                int y = nums[j];
                if(x + y == target) {
                    found = true;
                    break;
                }
            }
            if(found) {
                break;
            }
        }
        return new int[] {i, j};
    }
}
