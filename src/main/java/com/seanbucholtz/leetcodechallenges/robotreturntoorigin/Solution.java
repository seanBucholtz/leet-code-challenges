package com.seanbucholtz.leetcodechallenges.robotreturntoorigin;

/**
 * 657. Robot Return to Origin
 *
 * There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if
 * this robot ends up at (0, 0) after it completes its moves.
 *
 * The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are
 * R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves,
 * return true. Otherwise, return false.
 *
 * Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once,
 * "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for
 * each move.
 */
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
