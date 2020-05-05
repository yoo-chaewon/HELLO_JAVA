class Solution {
    public static int[] solution(int brown, int red) {
        int width = brown + red;
        int result = 0;
        for (int i = red; i >= 1; i--){
            if (red % i == 0){
                if (width == (i+2) * (red/i + 2)){
                    result = i+2;
                    break;
                }
            }
        }
        int[] answer = {result, width/result};
        return answer;
    }
}