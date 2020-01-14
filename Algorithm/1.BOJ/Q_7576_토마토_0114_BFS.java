import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N; //세로
    static int M; //가로
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] MN = bufferedReader.readLine().split(" ");
        M = Integer.parseInt(MN[0]);
        N = Integer.parseInt(MN[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        Queue<com.company.Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 1) {
                    queue.add(new com.company.Point(j, i));
                }
            }
        }
        BFS(queue);
        System.out.println(checkMap());
    }

    public static void BFS(Queue<com.company.Point> queue) {
        while (!queue.isEmpty()) {
            com.company.Point curPoint = queue.poll();
            visited[curPoint.y][curPoint.x] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = curPoint.x + dx[i];
                int nextY = curPoint.y + dy[i];

                if (nextX < 0 || nextY < 0 || M <= nextX || N <= nextY || visited[nextY][nextX] || map[nextY][nextX] == -1 || map[nextY][nextX] == 1)
                    continue;
                visited[nextY][nextX] = true;
                map[nextY][nextX] += map[curPoint.y][curPoint.x] + 1;
                queue.add(new com.company.Point(nextX, nextY));
            }
        }
    }

    public static int checkMap() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) return -1;
                if (map[i][j] != -1) max = Math.max(max, map[i][j]);
            }
        }
        return max - 1;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

