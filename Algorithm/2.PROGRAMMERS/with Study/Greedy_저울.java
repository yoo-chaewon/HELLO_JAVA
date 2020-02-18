import java.util.Arrays;

class Solution {
    public static int solution(int[] weight) {
        Arrays.sort(weight);
        int answer = 1;

        for (int i = 0; i < weight.length; i++){
            if (answer < weight[i]) break;
            answer+= weight[i];
        }
        return answer;
    }
}