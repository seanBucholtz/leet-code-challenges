package com.seanbucholtz.leetcodechallenges.robotreturntoorigin;

enum Move {

    U (new int[] {1, 0}),
    D (new int[] {-1, 0}),
    L (new int[] {0, -1}),
    R (new int[] {0, 1});

    final int[] coords;

    Move(int[] coords) {
        this.coords = coords;
    }
}
