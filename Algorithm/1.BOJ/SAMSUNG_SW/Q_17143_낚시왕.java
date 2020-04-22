import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static Point[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(input.nextToken());
        C = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());

        map = new Point[R][C];
        while (M-- > 0) {
            StringTokenizer str = new StringTokenizer(bufferedReader.readLine());
            int y = Integer.parseInt(str.nextToken());
            int x = Integer.parseInt(str.nextToken());
            int speed = Integer.parseInt(str.nextToken());
            int dir = Integer.parseInt(str.nextToken());
            if (dir == 1) dir = -1;
            else if (dir == 2) dir = 1;
            else if (dir == 3) dir = 2;
            else dir = -2;

            map[y - 1][x - 1] = new Point(x - 1, y - 1, speed, dir, Integer.parseInt(str.nextToken()));
        }

        int result = 0;
        for (int i = 0; i < C; i++) {
            result += CatchShark(i);
            MoveShark();
        }
        System.out.println(result);
    }

    public static void MoveShark() {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != null) {
                    queue.add(new Point(j, i, map[i][j].speed, map[i][j].dir, map[i][j].size));
                    map[i][j] = null;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int move = cur.speed;

            if (cur.dir == 1 || cur.dir == -1) {//up
                while (move-- > 0) {
                    if (cur.y == 0) cur.dir = 1;
                    else if (cur.y == R - 1 ) cur.dir = -1;
                    cur.y += cur.dir;
                }
            } else if (cur.dir == 2 || cur.dir == -2) {//left
                while (move-- > 0) {
                    if (cur.x == 0) cur.dir = 2;
                    else if (cur.x == C - 1) cur.dir =  -2;
                    cur.x += cur.dir / 2;
                }
            }

            if (map[cur.y][cur.x] == null) {
                map[cur.y][cur.x] = cur;
            } else {
                if (cur.size > map[cur.y][cur.x].size) {
                    map[cur.y][cur.x] = cur;
                }
            }
        }
    }

    public static int CatchShark(int location) {
        int result = 0;

        for (int i = 0; i < R; i++) {
            if (map[i][location] != null) {
                result += map[i][location].size;
                map[i][location] = null;
                break;
            }
        }
        return result;
    }
}

class Point {
    int x, y, speed, dir, size;

    Point(int x, int y, int speed, int dir, int size) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.dir = dir;
        this.size = size;
    }
}
