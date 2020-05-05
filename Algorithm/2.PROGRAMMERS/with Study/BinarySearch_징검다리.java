import java.util.Arrays;

class Solution {
    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int answer = 0;
        int left = 0;
        int right = distance;
        int mid = 0;

        while (left <= right){
            int remove = 0;
            int last = 0;
            mid = (left + right) /2;
            for (int i = 0; i <= rocks.length; i++){
                int sub = 0;
                if (i == rocks.length) sub = distance - last;
                else sub = rocks[i] - last;

                if (sub < mid) remove++;
                else if (i != rocks.length) last = rocks[i];
            }
            if (remove > n){
                right = mid -1;
            }else {
                answer = mid;
                left = mid +1;
            }
        }
        return answer;
    }
}