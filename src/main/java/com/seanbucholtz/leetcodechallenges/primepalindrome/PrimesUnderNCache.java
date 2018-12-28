package com.seanbucholtz.leetcodechallenges.primepalindrome;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.PriorityQueue;

public class PrimesUnderNCache {

    private class KeyQueueComparator implements Comparator<Integer> {

        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2) * -1;
        }
    }

    private PriorityQueue<Integer> keyQueue;
    private LinkedHashMap<Integer, List<Integer>> cacheMap;

    public PrimesUnderNCache() {
        this.keyQueue = new PriorityQueue<>(new PrimesUnderNCache.KeyQueueComparator());
        this.cacheMap = new LinkedHashMap<>();
    }

    public void add(int N, List<Integer> primes) {
        this.cacheMap.put(N, primes);
        this.keyQueue.add(N);
    }

    public boolean inCache(int N) {
        return cacheMap.containsKey(N);
    }

    public List<Integer> get(int N) {
        return this.cacheMap.get(N);
    }

    public Integer getLargestCacheKey() {
        return this.keyQueue.peek();
    }
}
