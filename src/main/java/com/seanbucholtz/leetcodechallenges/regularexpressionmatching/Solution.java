package com.seanbucholtz.leetcodechallenges.regularexpressionmatching;

public class Solution {
    public boolean isMatch(String s, String p) {
        String pattern = String.format("^(%s)$", p);
        return s.matches(pattern);
    }
}
