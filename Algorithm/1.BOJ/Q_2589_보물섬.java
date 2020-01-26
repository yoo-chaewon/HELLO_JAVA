import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static char[][] map;
    static int[][] result;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    boolean[][] visited = new boolean[N][M];
                    result = new int[N][M];
                    BFS(j, i, visited);
                    answer = Math.max(answer, CheckMax(result));
                }
            }
        }
        System.out.println(answer);
    }

    public static void BFS(int x, int y, boolean[][] visited) {
        visited[y][x] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curPoint.x + dx[i];
                int nextY = curPoint.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || visited[nextY][nextX] || map[nextY][nextX] == 'W')
                    continue;
                visited[nextY][nextX] = true;
                result[nextY][nextX] = result[curPoint.y][curPoint.x] + 1;
                queue.add(new Point(nextX, nextY));
            }
        }


    }

    public static int CheckMax(int[][] result) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(result[i][j], max);
            }
        }
        return max;

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