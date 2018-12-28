package com.seanbucholtz.leetcodechallenges.reverseinteger;

class Solution {
    public int reverse(int x) {
        StringBuilder intStringBuilder = new StringBuilder(Integer.toString(Math.abs(x)));
        intStringBuilder.reverse();
        if(intStringBuilder.indexOf("0") == 0) {
            intStringBuilder.deleteCharAt(0);
        }
        if(x < 0) {
            intStringBuilder.insert(0, '-');
        }

        int reversedInt;
        try {
            reversedInt = Integer.parseInt(intStringBuilder.toString());
        }
        catch (NumberFormatException e) {
            reversedInt = 0;
        }
        return reversedInt;
    }
}
