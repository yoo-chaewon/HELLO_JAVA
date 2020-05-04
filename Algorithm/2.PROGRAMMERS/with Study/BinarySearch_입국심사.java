import java.util.Arrays;

class Solution {
    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = Long.MAX_VALUE;
        long left = 0;
        long right = times[times.length-1];
        long mid;

        right *= n;
        while (left <= right) {
            long sum = 0;
            mid = (left + right) / 2;

            for (int time : times) {
                sum += mid / time;
            }

            if (sum < n) {
                left = mid + 1;
            } else {
                answer = Math.min(mid, answer);
                right = mid - 1;
            }
        }
        return answer;
    }
}