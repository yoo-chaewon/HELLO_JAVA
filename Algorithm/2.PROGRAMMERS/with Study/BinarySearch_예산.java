import java.util.Arrays;

class Solution {
    public static int solution(int[] budgets, int M) {
        int answer = 0;
        Arrays.sort(budgets);
        int left = 0;
        int right = budgets[budgets.length - 1];

        int mid = 0;
        while (left <= right) {
            long sum = 0;
            mid = (left + right) / 2;

            for (int budget : budgets) {
                if (budget >= mid) sum += mid;
                else sum += budget;
            }

            if (sum > M) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }
        return answer;
    }
}