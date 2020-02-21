import java.util.Arrays;

class Solution1 {
    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i = 0; i < citations.length; i++){
            if (citations[i] >= citations.length-i) {
                answer = Math.max(answer , citations.length-i);
            }
        }
        return answer;
    }
}