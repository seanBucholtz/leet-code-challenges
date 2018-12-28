package com.seanbucholtz.leetcodechallenges.validparentheses;

class Solution {
    public boolean isValid(String s) {
        boolean cont = s.length() != 0;
        boolean valid = true;
        int index = 0;
        while (cont) {
            if(s.length() == 0) {
                break;
            }
            if(index + 1 > s.length() -1 ) {
                valid = false;
                break;
            }
            char start = s.charAt(index);
            char end = s.charAt(index + 1);
            if(charsValidAndEqual(start, end)) {
                StringBuilder sub = new StringBuilder(s.substring(0, index));
                if(index + 2 < s.length()) {
                    sub.append(s.substring(index + 2, s.length()));
                }
                s = sub.toString();
                index = 0;
            }
            else {
                index++;
            }
        }
        return valid;
    }

    private boolean charsValidAndEqual(char c1, char c2) {
        boolean valid;
        switch (c1) {
            case '(':
                valid = Character.compare(c2, ')') == 0;
                break;
            case '{':
                valid = Character.compare(c2, '}') == 0;
                break;
            case '[':
                valid = Character.compare(c2, ']') == 0;
                break;
            default:
                valid = false;
                break;
        }
        return valid;
    }
}
