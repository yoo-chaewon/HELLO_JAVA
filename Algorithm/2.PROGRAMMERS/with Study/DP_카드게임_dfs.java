import java.util.Arrays;

class Solution {
    public static int solution(int[] left, int[] right) {
        return game(left, right, 0, 0, 0);
    }

    public static int game(int[] left, int[] right, int leftIndx, int rightIndx, int score) {
        if (left.length == leftIndx || right.length == rightIndx) return score;
        if (left[leftIndx] > right[rightIndx]){
            return game(left, right, leftIndx, rightIndx+1, score+right[rightIndx]);
        }else {
            return Math.max(game(left, right, leftIndx+1, rightIndx+1,score),
                    game(left,right, leftIndx+1, rightIndx, score));
        }
    }
}