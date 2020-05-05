import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int N, M;
    static ArrayList<Point> cctv = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(input.nextToken());
        M = Integer.parseInt(input.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++){
            input = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(input.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) cctv.add(new Point(j, i, map[i][j]));
            }
        }
        Go(0, map);
        System.out.println(answer);
    }

    static int[][] cctv_dir = {
            {0},
            {0, 2},
            {1, 2},
            {0, 1, 2},
            {0, 1, 2, 3}
    };
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void Go(int depth, int[][] arr){
        if (depth == cctv.size()){
            int count = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (arr[i][j] == 0) count++;
                }
            }
            answer = Math.min(answer, count);
            return;
        }

        Point cur = cctv.get(depth);
        for (int k = 0; k < 4; k++){
            int[][] map = copyMap(arr);

            for (int i = 0; i < cctv_dir[cur.type-1].length; i++){
                int dir = (cctv_dir[cur.type-1][i] + k ) % 4;
                int nextX = cur.x;
                int nextY = cur.y;

                while (true){
                    nextX += dx[dir];
                    nextY += dy[dir];
                    if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || map[nextY][nextX] == 6) break;
                    map[nextY][nextX] = -1;
                }
            }
            Go(depth+1, map);
        }
    }

    public static int[][] copyMap(int[][] arr){
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = arr[i][j];
            }
        }
        return map;
    }
}
class Point{
    int x, y, type;
    Point(int x, int y, int type){
        this.x = x;
        this.y = y;
        this.type = type;
    }
}