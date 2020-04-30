public class Solution {
    public static int solution(int[] stones, int k) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int stone : stones){
            max = Math.max(max, stone);
            min = Math.min(min, stone);
        }
        int mid;
        while (max >= min){
            mid = (max + min) /2;
            if (isPossible(mid, stones.clone(), k)){
                min = mid+1;
                answer = Math.max(answer, mid);
            }else {
                max = mid-1;
            }
        }
        return answer;
    }

    public static boolean isPossible(int mid, int[] stones, int k){
        for (int i = 0; i < stones.length; i++){
            stones[i] -= mid;
        }
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < 0) {
                count++;
                if (count >= k) return false;
            }else count = 0;
        }
        return true;
    }
}
