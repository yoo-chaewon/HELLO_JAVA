import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        int answer = 0;

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    if (!basket.isEmpty() && board[i][move - 1] == basket.peek()) {
                        answer += 2;
                        basket.pop();
                    } else {
                        basket.push(board[i][move - 1]);
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}