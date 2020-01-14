//시간초과
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;// 세로, 가로
    static int[][] map;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNM = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(inputNM[0]);
        M = Integer.parseInt(inputNM[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        DFS(0, 0, 0);
        System.out.println(min);
    }

    public static void DFS(int x, int y, int count) {
        visited[y][x] = true;
        count++;

        if (x == M - 1 && y == N - 1) {
            min = Math.min(min, count);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || M <= nextX || N <= nextY || visited[nextY][nextX] || map[nextY][nextX] == 0 || min < count)
                continue;
            visited[nextY][nextX] = true;
            DFS(nextX, nextY, count);
            visited[nextY][nextX] = false;
        }
    }
}