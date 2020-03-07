import java.util.ArrayList;

class Solution {
    public static int[] solution(int[] prices) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < prices.length-1; i++){
            int count = 0;
            for (int j = i+1; j <prices.length; j++){
                count++;
                if (prices[i] > prices[j]) break;
            }
            result.add(count);
        }
        result.add(0);

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}