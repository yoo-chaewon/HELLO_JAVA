import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int max;
    static int[][] map;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(input.nextToken());
        M = Integer.parseInt(input.nextToken());
        max = N * M;

        map = new int[N][M];
        for (int i = 0; i < N; i++){
            input = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(input.nextToken());
            }
        }
        Prevent(0);
        System.out.println(answer);
    }
    public static void Prevent(int depth){
        if (depth == 3){
            int[][] print = new int[N][M];
            for (int i = 0; i < N ; i++){
                for (int j = 0; j < M; j++){
                    print[i][j] = map[i][j];
                }
            }
            answer = Math.max(answer, Find(print));
            return;
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 0){
                    map[i][j] = 1;
                    Prevent(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static int Find(int[][] map){
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 2) queue.add(new Point(j, i));
            }
        }

        boolean[][] visited = new boolean[N][M];
        while (!queue.isEmpty()){
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || visited[nextY][nextX]
                        || map[nextY][nextX] != 0) continue;
                visited[nextY][nextX] = true;
                queue.add(new Point(nextX, nextY));
                map[nextY][nextX] = 2;
            }
        }
        return Count(map);
    }

    public static int Count(int[][] map){
        int count = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0 ; j < M; j++){
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }
}
class Point{
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}