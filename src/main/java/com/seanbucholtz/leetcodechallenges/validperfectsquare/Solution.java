package com.seanbucholtz.leetcodechallenges.validperfectsquare;

public class Solution {
    public boolean isPerfectSquare(int num) {
        int[] iterationRange = this.getIterationRange(num);
        for(int i = iterationRange[1]; i >= iterationRange[0]; i--) {
            int squared = i * i;
            if(squared == num) {
                return true;
            }
        }
        return false;
    }

    private int[] getIterationRange(int target) {
        int targetCharacterLength = this.getTargetCharacterLength(target);
        int[] principleLengthRange = this.findPrincipleLengthRange(targetCharacterLength);
        return this.generatePrincipleValueRange(principleLengthRange);
    }

    private int getTargetCharacterLength(int target) {
        return String.valueOf(target).length();
    }

    private int[] findPrincipleLengthRange(int targetCharacterLength) {
        int previous = 0;
        int current = 1;
        boolean maximumPrincipleLengthNotFound = true;
        while (maximumPrincipleLengthNotFound) {
            int sum = previous + current;
            if(sum >= targetCharacterLength) {
                maximumPrincipleLengthNotFound = false;
            }
            else {
                previous ++;
                current ++;
            }
        }
        return new int[]{previous, current};
    }

    private int[] generatePrincipleValueRange(int[] principleLengthRange) {
        int minLength = principleLengthRange[0];
        minLength = minLength == 0 ? 1 : minLength;
        return new int[] {
                this.getRepeatingIntOfLength(minLength, 0, 1),
                this.getRepeatingIntOfLength(principleLengthRange[1], 9, null)
        };
    }

    private int getRepeatingIntOfLength(int length, int repeatingInt, Integer startingInt) {
        if(length <= 0) {
            throw new RuntimeException("length must be greater than zero");
        }

        String seed = startingInt == null ? "" : String.valueOf(startingInt);
        StringBuilder repeatingIntBuilder = new StringBuilder(seed);

        while (repeatingIntBuilder.length() < length) {
            repeatingIntBuilder.append(repeatingInt);
        }

        if(repeatingIntBuilder.length() > length) {
            int diff = length - repeatingIntBuilder.length();
            repeatingIntBuilder.delete(0, repeatingIntBuilder.length() - diff);
        }

        return Integer.parseInt(repeatingIntBuilder.toString());
    }
}
