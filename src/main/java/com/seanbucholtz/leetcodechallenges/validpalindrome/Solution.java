package com.seanbucholtz.leetcodechallenges.validpalindrome;

public class Solution {

    public boolean isPalindrome(String s) {
        return this.isPalindromeImproved(s);
    }

    public boolean isPalindromeNaive(String s) {
        if(s == null) {
            return false;
        }
        s = s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase().trim(); // costly?
        for(int i = 0; i <= s.length() / 2 && s.length() != 0; i++) {
            if(s.charAt(i) != s.charAt(s.length()- 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeImproved(String s) {
        if(s == null) {
            return false;
        }

        int leftAhead = 0;
        int rightAhead = 0;

        for(int i = 0; i <= s.length() / 2 && s.length() > 0; i++) {

            int leftIndex = i + leftAhead;
            int rightIndex = s.length() - 1 - (i + rightAhead);

            if(leftIndex > s.length() / 2 || rightIndex < s.length() / 2 ) {
                break;
            }

            char left = s.charAt(leftIndex);
            char right = s.charAt(rightIndex);

            while(!Character.isLetterOrDigit(left)) {
                leftAhead ++;
                leftIndex ++;
                if(leftIndex > s.length() -1) {
                    break;
                }
                left = s.charAt(leftIndex);
            }

            while(!Character.isLetterOrDigit(right)) {
                rightAhead++;
                rightIndex --;
                if(rightIndex < 0) {
                    break;
                }
                right = s.charAt(rightIndex);
            }


            if(Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }

        }
        return true;
    }
}
