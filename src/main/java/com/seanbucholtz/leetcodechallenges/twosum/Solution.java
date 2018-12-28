package com.seanbucholtz.leetcodechallenges.twosum;

class Solution {
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
