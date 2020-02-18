import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        for (int i = 0; i < lost.length; i++) {
            arr[lost[i] - 1]--;
        }

        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (i != 0 && arr[i] == 2 && arr[i - 1] == 0) {
                arr[i]--;
                arr[i - 1]++;
            }
            if (i != n - 1 && arr[i] == 2 && arr[i + 1] == 0) {
                arr[i]--;
                arr[i + 1]++;
            }
        }

        for (int a : arr) {
            if (a > 0) answer++;
        }

        return answer;
    }
}