package com.seanbucholtz.leetcodechallenges.reversewordsinastring;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder rtn = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == ' ' && word.length() > 0) {
                rtn.append(word).append(c);
                word = new StringBuilder();
            }
            else if(c != ' ') word.insert(0, c);

            if(i == 0) rtn.append(word).append(" ");
        }
        return rtn.toString().trim();
    }
}
