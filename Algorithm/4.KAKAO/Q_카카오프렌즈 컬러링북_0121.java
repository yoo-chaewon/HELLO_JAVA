class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int count = 0;

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (picture[i][j] != 0 && !visited[i][j]){
                    numberOfArea++;
                    DFS(picture, n, m, j, i, picture[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                    count = 0;
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void DFS(int[][] picture, int xSize, int ySize, int x, int y, int cur){
        visited[y][x] = true;
        count++;

        for (int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= xSize || nextY >= ySize || visited[nextY][nextX] || cur != picture[nextY][nextX]) continue;

            DFS(picture, xSize, ySize, nextX, nextY, cur);
        }
    }
}