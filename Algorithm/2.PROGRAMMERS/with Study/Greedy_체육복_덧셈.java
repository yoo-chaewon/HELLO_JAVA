class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];

        for (int i = 0; i < lost.length; i++) arr[lost[i] - 1]--;
        for (int i = 0; i < reserve.length; i++) arr[reserve[i] - 1]++;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] + arr[i + 1] == 0) {
                arr[i] = 0;
                arr[i + 1] = 0;
            }
        }

        for (int a : arr) if (a == 0) answer++;
        return answer;
    }
}
