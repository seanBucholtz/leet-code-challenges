package com.seanbucholtz.leetcodechallenges.robotreturntoorigin;

class Solution {

    public boolean judgeCircle(String moves) {
        Move[] movesArr = new Move[moves.length()];
        int count = 0;
        for(char move: moves.toCharArray()) {
            switch (move) {
                case 'U':
                    movesArr[count] = Move.U;
                    break;
                case 'D':
                    movesArr[count] = Move.D;
                    break;
                case 'L':
                    movesArr[count] = Move.L;
                    break;
                case 'R':
                    movesArr[count] = Move.R;
                    break;
                default:
                    break;
            }
            count++;
        }

        int[] sum = sumMoves(movesArr);
        return sum[0] == 0 && sum[1] == 0;
    }

    private int[] sumMoves(Move... moves) {
        if(moves.length > 0) {
            int x = moves[0].coords[0];
            int y = moves[0].coords[1];
            for(int i = 1; i < moves.length; i++) {
                x += moves[i].coords[0];
                y += moves[i].coords[1];
            }
            return new int[] {x, y};
        }
        else {
            return new int[2];
        }
    }
}
