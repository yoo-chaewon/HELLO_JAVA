import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int size;
    static int map[][];
    static int sharkSize = 2;
    static int eat = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());
        map = new int[size][size];

        Point start = new Point(0, 0, 0);
        for (int i = 0; i < size; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    start = new Point(j, i, 0);
                }
            }
        }
        System.out.println(Solution(start));
    }

    public static int Solution(Point start) {
        Point cur = start;
        int result = 0;

        while (true){
            ArrayList<Point> shortest = searchShortest(cur);
            if (shortest.isEmpty()) break;
            Collections.sort(shortest, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    /*
                     * 1. distance
                     * 2. y
                     * 3. x
                     * */
                    if (o1.walk != o2.walk) return o1.walk-o2.walk;
                    else if (o1.y != o2.y) return o1.y-o2.y;
                    else return o1.x-o2.x;
                }
            });
            Point tmp = shortest.get(0);
            map[tmp.y][tmp.x] = 0;
            result += tmp.walk;
            cur = new Point(tmp.x, tmp.y, 0);
            eat++;
            if (eat == sharkSize){
                eat = 0;
                sharkSize++;
            }
        }
        return result;
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static ArrayList<Point> searchShortest(Point point) {
        Queue<Point> queue = new LinkedList<>();
        ArrayList<Point> result = new ArrayList<>();
        boolean[][] visited = new boolean[size][size];
        queue.add(point);
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            visited[cur.y][cur.x] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size || visited[nextY][nextX] || map[nextY][nextX] > sharkSize) continue;
                visited[nextY][nextX] = true;
                queue.add(new Point(nextX, nextY, cur.walk + 1));
                if (map[nextY][nextX] != 0 && sharkSize > map[nextY][nextX]) result.add(new Point(nextX, nextY, cur.walk+1));
            }
        }
        return result;
    }
}

class Point {
    int x;
    int y;
    int walk;
    Point(int x, int y, int walk) {
        this.x = x;
        this.y = y;
        this.walk = walk;
    }
}
