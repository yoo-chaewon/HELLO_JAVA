class Solution {
    static int size;
    static boolean[] visited;
    public static int solution(int n, int[][] computers) {
        size = n;
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < size; i++){
            if (!visited[i]){
                answer++;
                DFS(computers, i);
            }
        }
        return answer;
    }

    public static void DFS(int[][] computers, int upper){
        visited[upper] = true;
        for (int i = 0; i < size; i++){
            if (computers[upper][i] == 1 && !visited[i]){
                DFS(computers, i);
            }
        }
    }
}