import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy ={0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(NM[0]);//세로
        M = Integer.parseInt(NM[1]);//가로
        int answer = Integer.MIN_VALUE;

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++){
            String[] input = bufferedReader.readLine().split("");
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 1){
                    map[i][j] = 0;
                    boolean[][] visited = new boolean[N][M];

                    answer = Math.max(answer, BFS(map, visited));
                    map[i][j] = 1;

                }
            }
        }
        if (answer == 0) System.out.println(-1);
        else System.out.println(answer);
    }

    public static int BFS(int[][] map, boolean[][] visited){
        int[][] result = new int[N][M];
        result[0][0] = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()){
            Point curPoint = queue.poll();
            for (int i = 0; i < 4; i++){
                int nextX = curPoint.x + dx[i];
                int nextY = curPoint.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || visited[nextY][nextX] || map[nextY][nextX] == 1) continue;
                queue.add(new Point(nextX, nextY));
                visited[nextY][nextX] = true;
                result[nextY][nextX] = result[curPoint.y][curPoint.x] + 1;
            }
        }
        return result[N-1][M-1];
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