import java.util.Arrays;

class Solution {
    static int[][] memo;
    public static int solution(int[] left, int[] right) {
        memo = new int[left.length][right.length];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return game(left, right, 0, 0);
    }

    public static int game(int[] left, int[] right, int leftIndx, int rightIndx) {
        if (left.length == leftIndx || right.length == rightIndx) return 0;
        if (memo[leftIndx][rightIndx] != -1) return memo[leftIndx][rightIndx];
        if (right[rightIndx] < left[leftIndx]) {
            int cur = game(left, right, leftIndx, rightIndx + 1) + right[rightIndx];
            memo[leftIndx][rightIndx] = cur;
            return cur;
        } else {
            int cur = Math.max(game(left, right, leftIndx + 1, rightIndx + 1),
                    game(left, right, leftIndx + 1, rightIndx));
            memo[leftIndx][rightIndx] = cur;
            return cur;
        }
    }
}