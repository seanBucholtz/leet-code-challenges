package com.seanbucholtz.leetcodechallenges.primepalindrome;

import java.util.*;

class Solution {
    public int primePalindrome(int N) {
        int primeCandidate = N;
        PrimesUnderNCache primesUnderNCache = new PrimesUnderNCache();
        for(; primeCandidate >= N; primeCandidate++) {

            if(!isPalindrome(primeCandidate)) {
                continue;
            }

            boolean isPrime = primeCandidate > 1; // 1 (one) is not prime

            int primeCandidateSqrt = (int) Math.sqrt(primeCandidate);

            List<Integer> primesUnderN = primesUnderNCache.get(primeCandidateSqrt);

            if(primesUnderN == null) {
                Integer largestKey = primesUnderNCache.getLargestCacheKey();
                List<Integer> primesUnderList = largestKey == null ? null : primesUnderNCache.get(largestKey);
                primesUnderN = addPrimesUnder(primeCandidateSqrt, primesUnderList);
                primesUnderNCache.add(primeCandidateSqrt, primesUnderN);
            }

            for(Integer prime : primesUnderN) {
                if(primeCandidate % prime == 0) {
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
            if(numChars[i] != numChars[num.length() - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> addPrimesUnder(int n, List<Integer> primesUnderList) {
        List<Integer> newPrimesUnderList = primesUnderList == null ? new ArrayList<>() :
                new ArrayList<>(primesUnderList);

        int startingVal = newPrimesUnderList.size() > 0 ? primesUnderList.get(primesUnderList.size() - 1) + 1 : 2;
        for(int p = startingVal; p < n; p++) {
            boolean isPrime = true;
            for(int div = 2; div <= Math.sqrt(p); div++) {
                if(p % div == 0 && p != div) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                newPrimesUnderList.add(p);
            }
        }
        return newPrimesUnderList;
    }
}
