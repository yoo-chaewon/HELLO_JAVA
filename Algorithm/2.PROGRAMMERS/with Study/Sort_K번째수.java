import java.util.Arrays;

class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;

        for (int i = 0; i < commands.length; i++) {
            int[] tmp = new int[commands[i][1] - commands[i][0]+1];
            for (int j = 0; j <= commands[i][1] - commands[i][0]; j++) {
                tmp[j] = array[j+commands[i][0]-1];
            }
            Arrays.sort(tmp);
            answer[index++] = tmp[commands[i][2]-1];
        }
        return answer;
    }
}