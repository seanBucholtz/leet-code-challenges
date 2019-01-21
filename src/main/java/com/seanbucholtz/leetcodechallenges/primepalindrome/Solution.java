package com.seanbucholtz.leetcodechallenges.primepalindrome;

class Solution {
    public int primePalindrome(int N) {
        int primeCandidate = N;
        for(; primeCandidate >= N; primeCandidate++) {

            if(primeCandidate > 9 && !isPalindrome(primeCandidate)) {
                continue;
            }

            boolean isPrime = primeCandidate > 1; // 1 (one) is not prime

            if((primeCandidate != 2 && primeCandidate != 3) && (primeCandidate % 2 == 0 || primeCandidate % 3 == 0)) {
                isPrime = false;
            }
            else {
                int upperBound = (int) Math.sqrt(primeCandidate);
                for(int i = 1; 6 * i - 1 <= upperBound || 6 * i + 1 <= upperBound; i++) {
                    if(primeCandidate % (6 * i - 1) == 0 || primeCandidate % (6 * i + 1) == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if(isPrime) {
                break;
            }
        }
        return primeCandidate;
    }

    /**
     * 0(n/2)
     * @param n
     * @return
     */
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

    private int[] generateCoefficients(int p) {
        int[] matrix = new int[p];
        return matrix; // TODO
    }
}
