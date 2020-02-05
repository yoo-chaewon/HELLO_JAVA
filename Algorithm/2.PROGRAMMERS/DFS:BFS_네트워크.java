class Solution {
    static int size = 0;

    public static int solution(int n, int[][] computers) {
        size = n;
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                answer++;
                DFS(i, computers, visited);
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void DFS(int top, int[][] computers, boolean[] visited){
        visited[top] = true;

        for (int i = 0; i < size; i++){
            if (computers[top][i] == 1 && !visited[i]){
                DFS(i, computers, visited);
            }
        }
    }
}