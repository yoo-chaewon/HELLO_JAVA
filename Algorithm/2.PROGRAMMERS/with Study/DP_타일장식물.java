class Solution {
    public static long solution(int N) {
        if (N == 1) return 4;
        long[] map = new long[N];
        map[0] = 1;
        map[1] = 1;
        for (int i = 2; i < N; i++) {
            map[i] = map[i - 1] + map[i - 2];
        }
        return map[N - 1] * 4 + map[N - 2] * 2;
    }
}