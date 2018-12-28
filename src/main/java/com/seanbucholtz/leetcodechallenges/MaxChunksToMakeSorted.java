package com.seanbucholtz.leetcodechallenges;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        return this.maxChunksSortedRecursive(arr, 0);
    }

    private int maxChunksSortedRecursive(int[] arr, int chunksCount) {
        if(arr.length == 0) {
            return chunksCount;
        }
        else {
            int smallestVal = arr[0];
            int smallestValIndex = 0;
            for(int i = 0; i < arr.length; i++) {
                int val = arr[i];
                if(val < smallestVal) {
                    smallestVal = val;
                    smallestValIndex = i;
                }
            }
            int largestValInNewChunk = arr[0];
            for(int i = 0; i <= smallestValIndex; i++) {
                int val = arr[i];
                if(val > largestValInNewChunk) {
                    largestValInNewChunk = val;
                }
            }

            int cutoffIndex = smallestValIndex;
            for(int i = cutoffIndex + 1; i < arr.length; i++) {
                int val = arr[i];
                if(val < largestValInNewChunk) {
                    cutoffIndex = i;
                }
            }

            int numOfValuesToCopy = arr.length - cutoffIndex -1;
            int[] subArr = new int[numOfValuesToCopy];
            System.arraycopy(arr, cutoffIndex + 1, subArr, 0, numOfValuesToCopy);

            chunksCount ++;

            return maxChunksSortedRecursive(subArr, chunksCount);
        }
    }
}
