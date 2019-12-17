import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int N, M;//세로 가로//
    static Queue<com.company.Point> queue = new LinkedList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        M = scanner.nextInt();//가로
        N = scanner.nextInt();//세로
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 1){
                    queue.add(new com.company.Point(j, i));
                }

            }
        }

        BFS(queue);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                max = Math.max(max, map[i][j]);
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max-1);
    }

    public static void BFS(Queue<com.company.Point> queue) {
        while (!queue.isEmpty()) {
            com.company.Point cur = queue.poll();
            visited[cur.y][cur.x] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (N <= nextY || M <= nextX || nextX < 0 || nextY < 0 || visited[nextY][nextX] || map[nextY][nextX] != 0 || map[nextY][nextX] == -1) continue;
                queue.add(new com.company.Point(nextX, nextY));
                map[nextY][nextX] = map[cur.y][cur.x] + 1;
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

