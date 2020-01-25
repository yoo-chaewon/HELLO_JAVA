import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int size;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());
        while (testCase-- > 0){
            size = Integer.parseInt(bufferedReader.readLine());
            map = new int[size][size];
            visited = new boolean[size][size];

            String[] start = bufferedReader.readLine().split(" ");
            String[] arrive = bufferedReader.readLine().split(" ");

            BFS(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
            System.out.println(map[Integer.parseInt(arrive[1])][Integer.parseInt(arrive[0])]);
        }
    }

    public static void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[y][x] = true;

        while (!queue.isEmpty()){
            Point curPoint = queue.poll();
            int curX = curPoint.x;
            int curY = curPoint.y;

            for (int i = 0; i < 8; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextY < 0 || size <= nextX || size <= nextY || visited[nextY][nextX]) continue;
                map[nextY][nextX] = map[curY][curX] + 1;
                visited[nextY][nextX] = true;
                queue.add(new Point(nextX, nextY));
            }
        }
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

