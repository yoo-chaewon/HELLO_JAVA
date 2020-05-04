class Solution {
    static int answer = 0;
    public static int solution(int K, int[][] travel) {
        DFS(K, travel, 0, 0, 0);
        return answer;
    }

    public static void DFS(int K, int[][] travel, int depth, int time, int money) {
        if (depth == travel.length) {
            if (time <= K) answer = Math.max(money, answer);
            return;
        }

        DFS(K, travel, depth + 1, time + travel[depth][0], money + travel[depth][1]);
        DFS(K, travel, depth + 1, time + travel[depth][2], money + travel[depth][3]);
    }
}