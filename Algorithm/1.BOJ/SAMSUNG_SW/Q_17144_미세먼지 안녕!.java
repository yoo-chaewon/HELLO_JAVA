import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(input.nextToken());
        C = Integer.parseInt(input.nextToken());
        int T = Integer.parseInt(input.nextToken());
        int machine = 0;

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            StringTokenizer str = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
                if (map[i][j] == -1) machine = i;
            }
        }

        while (T-- > 0) {
            Spread();
            Run(machine-1, new int[]{1,2,0,3});
            Run(machine, new int[] {1,3,0,2});
        }
        System.out.println(Check());
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void Spread() {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1 && map[i][j] != 0) {
                    queue.add(new Point(j, i, map[i][j]));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int spread = cur.dust / 5;

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= C || nextY >= R || map[nextY][nextX] == -1) continue;
                map[nextY][nextX] += spread;
                map[cur.y][cur.x] -= spread;
            }
        }
    }

    public static void Run(int machine, int[] direction) {
        int x = 1;
        int y = machine;
        int tmp1 = map[y][x];
        int tmp2;
        map[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            while (true) {
                int nextX = x + dx[direction[i]];
                int nextY = y + dy[direction[i]];

                if (nextX < 0 || nextY < 0 || nextX >= C || nextY >= R) break;
                if (map[nextY][nextX] == -1) break;

                tmp2 = map[nextY][nextX];
                map[nextY][nextX] = tmp1;
                tmp1 = tmp2;

                x = nextX;
                y = nextY;
            }
        }
    }

    public static int Check(){
        int result = 0;
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (map[i][j] != -1) result += map[i][j];
            }
        }
        return result;
    }
}

class Point {
    int x;
    int y;
    int dust;

    Point(int x, int y, int dust) {
        this.x = x;
        this.y = y;
        this.dust = dust;
    }
}
