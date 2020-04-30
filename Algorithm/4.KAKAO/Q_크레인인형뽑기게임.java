import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer>[] board_stack = new Stack[board.length];
        for (int i = 0; i < board.length; i++){
            board_stack[i] = new Stack<>();
        }
        for (int i = board.length-1; i >= 0 ; i--){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] != 0) board_stack[j].add(board[i][j]);
            }
        }
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int move : moves){
            if (!board_stack[move-1].isEmpty()){
                int cur = board_stack[move-1].pop();
                if (!basket.isEmpty() && cur == basket.peek()){
                    answer+=2;
                    basket.pop();
                }else {
                    basket.push(cur);
                }
            }
        }
        return answer;
    }
}