package com.seanbucholtz.leetcodechallenges.compareversionnumbers;

import java.util.Comparator;

@SuppressWarnings("Duplicates")
public class Solution {

    class Version implements Comparator<Version> {

        static final String VERSION_DELIMITER = "\\.";

        private final Integer[] versionArray;
        private final String versionString;

        public Version(String version) {
            this.versionString = version;
            String[] versionStringArr = version.split(VERSION_DELIMITER);
            Integer[] versionIntArr = new Integer[versionStringArr.length];
            for(int i = 0; i < versionStringArr.length; i++) {
                versionIntArr[i] = Integer.parseInt(versionStringArr[i]);
            }
            this.versionArray = versionIntArr;
        }

        @Override
        public String toString() {
            return this.versionString;
        }

        public int compare(Version v1, Version v2) {
            for(int i = 0; i < v1.versionArray.length && i < v2.versionArray.length; i++) {
                int diff = v1.versionArray[i] - v2.versionArray[i];
                if(diff != 0) {
                    return diff > 0 ? 1 : -1;
                }
            }
            int diff = v1.versionArray.length - v2.versionArray.length;

            if(diff == 0) {
                return diff;
            }

            boolean remainderAllZeros;

            if(diff > 0) {
                remainderAllZeros = allZeros(v1.versionArray, v2.versionArray.length, v1.versionArray.length);
            }
            else {
                remainderAllZeros = allZeros(v2.versionArray, v1.versionArray.length, v2.versionArray.length);
            }

            if(remainderAllZeros) {
                return 0;
            }

            return diff > 0 ? 1 : -1;
        }

        private boolean allZeros(Integer[] integers, int from, int to) {
            for(int i = from; i < integers.length && i < to; i++) {
                if(integers[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public Version getVersion(String version) {
        return new Version(version);
    }

    public int compareVersion(String version1, String version2) {
        Version v1 = new Version(version1);
        Version v2 = new Version(version2);
        return v1.compare(v1, v2);
    }

}
