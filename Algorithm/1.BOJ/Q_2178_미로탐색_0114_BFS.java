import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;// 세로, 가로
    static int[][] map;
    static boolean[][] visited;

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
        BFS(0, 0);
        System.out.println(map[N-1][M-1]);
    }

    public static void BFS(int x, int y) {
        Queue<com.company.Point> queue = new LinkedList<>();
        queue.add(new com.company.Point(x, y));
        visited[y][x] = true;

        while (!queue.isEmpty()){
            com.company.Point curPoint = queue.poll();
            if (curPoint.x == M-1 && curPoint.y == N-1) return;

            for (int i = 0; i < 4; i++){
                int nextX = curPoint.x + dx[i];
                int nextY = curPoint.y + dy[i];

                if (nextX < 0 || nextY < 0 || M <= nextX || N <= nextY || visited[nextY][nextX] || map[nextY][nextX] == 0) continue;
                visited[nextY][nextX] = true;
                map[nextY][nextX] += map[curPoint.y][curPoint.x];
                queue.add(new com.company.Point(nextX, nextY));
            }
        }
    }
}
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
