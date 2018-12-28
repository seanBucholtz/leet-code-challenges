package com.seanbucholtz.leetcodechallenges.maxchunkstomakesorted;

/**
 * Max Chunks To Make Sorted
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        return this.maxChunksSortedRecursive(arr, 0);
    }

    private int maxChunksSortedRecursive(int[] arr, int chunksCount) {
        if(arr.length == 0) {
            return chunksCount;
        }

        int smallestVal = arr[0];
        int smallestValIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if(val < smallestVal) {
                smallestVal = val;
                smallestValIndex = i;
            }
        }
        int largestValIndexInNewChunk = findLargestValueIndex(arr, 0, smallestValIndex);

        int cutoffIndex = smallestValIndex;
        for(int i = cutoffIndex + 1; i < arr.length; i++) {
            if(arr[i] < arr[largestValIndexInNewChunk]) {
                cutoffIndex = i;
                largestValIndexInNewChunk = findLargestValueIndex(arr, largestValIndexInNewChunk, cutoffIndex);
            }
        }

        chunksCount ++;

        int numOfValuesToCopy = arr.length - cutoffIndex -1;
        int[] subArr = new int[numOfValuesToCopy];
        System.arraycopy(arr, cutoffIndex + 1, subArr, 0, numOfValuesToCopy);

        return maxChunksSortedRecursive(subArr, chunksCount);

    }

    private int findLargestValueIndex(int[] arr, int startIndex, int stopIndex) {
        int largestValueIndex = startIndex;
        for(int i = startIndex; i < stopIndex; i++) {
            int value = arr[i];
            if(value > arr[largestValueIndex]) {
                largestValueIndex = i;
            }
        }
        return largestValueIndex;
    }
}
