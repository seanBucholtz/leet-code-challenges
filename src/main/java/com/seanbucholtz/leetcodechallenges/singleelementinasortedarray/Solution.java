package com.seanbucholtz.leetcodechallenges.singleelementinasortedarray;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length % 2 == 0 || nums.length == 0)
            throw new RuntimeException("No single element in this array");
        int num = nums[0];
        for(int i = 0; i < nums.length; i++) {
            num = nums[i];
            if(i < 1 && nums.length > i+1 && nums[i+1] != num) return num;
            if(i > 0 && nums.length > i+1 && !(nums[i-1] == num || nums[i+1] == num))
                return num;
        }
        return num;
    }
}
