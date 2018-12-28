package com.seanbucholtz.leetcodechallenges.primepalindrome;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int primePalindrome(int N) {
        int primeCandidate = N;
        for(; primeCandidate >= N; primeCandidate++) {

            if(!isPalindrome(primeCandidate)) {
                continue;
            }

            boolean isPrime = primeCandidate > 1; // 1 (one) is not prime

            for(int divisor = 2; divisor <= Math.sqrt(primeCandidate); divisor++) {
                if(primeCandidate % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                break;
            }
        }
        return primeCandidate;
    }

    private boolean isPalindrome(int n) {
        String num = String.valueOf(n);
        char[] numChars = num.toCharArray();
        for(int i = 0; i <= numChars.length / 2; i++) {
            if(Character.compare(numChars[i], numChars[num.length() - 1 - i]) != 0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getPrimesUnder(int n) {
        List<Integer> primes = new ArrayList<Integer>()
    }
}
