import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int M, N, H;
    static int[][][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] MNH = bufferedReader.readLine().split(" ");
        M = Integer.parseInt(MNH[0]);//가로
        N = Integer.parseInt(MNH[1]);//세로
        H = Integer.parseInt(MNH[2]);//층

        map = new int[H][N][M];
        visited = new boolean[H][N][M];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                String[] input = bufferedReader.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(input[k]);
                    if (map[i][j][k] == 1) queue.add(new Point(k, j, i));
                }
            }
        }

        BFS(queue);
        System.out.println(Check());
    }

    public static void BFS(Queue<Point> queue) {
        while (!queue.isEmpty()){
            Point curPoint = queue.poll();

            for (int i = 0; i < 6; i++){
                int nextX = curPoint.x + dx[i];
                int nextY = curPoint.y + dy[i];
                int nextZ = curPoint.z + dz[i];

                if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= M || nextY >= N || nextZ >= H || visited[nextZ][nextY][nextX] || map[nextZ][nextY][nextX] != 0) continue;
                queue.add(new Point(nextX, nextY, nextZ));
                visited[nextZ][nextY][nextX] = true;
                map[nextZ][nextY][nextX] = map[curPoint.z][curPoint.y][curPoint.x] + 1;
            }
        }
    }

    public static int Check() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    max = Math.max(max, map[i][j][k]);
                    if (map[i][j][k] == 0) return -1;
                }
            }
        }
        return max-1;
    }
}

class Point {
    int x;
    int y;
    int z;

    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
