import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int height = 12;
    static int width = 6;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        map = new char[height][width];

        for (int i = 0; i < height; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int result = 0;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (map[i][j] != '.' && Find(j, i, map[i][j])) {
                        flag = true;
                    }
                }
            }
            Remove();
            if (flag)result++;
            else {
                System.out.println(result);
                return;
            }
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static boolean Find(int x, int y, char cur) {
        boolean flag = false;
        boolean[][] visited = new boolean[height][width];
        List<Point> remove = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[y][x] = true;
        remove.add(new Point(x, y));
        int count = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= width || nextY >= height || visited[nextY][nextX] || map[nextY][nextX] != cur)
                    continue;
                visited[nextY][nextX] = true;
                queue.add(new Point(nextX, nextY));
                remove.add(new Point(nextX, nextY));
            }
        }

        if (count >= 4) {
            for (Point point : remove){
                map[point.y][point.x] = '.';
                flag = true;
            }
        }
        return flag;
    }

    public static void Remove() {
        for (int i = 0; i < width; i++) {
            ArrayList<Character> puyo = new ArrayList<>();
            for (int j = height - 1; j >= 0; j--) {
                if ( map[j][i] != '.') {
                    puyo.add(map[j][i]);
                }
            }

            int index = 0;
            for (int j = height - 1; j >= 0; j--) {
                if (index < puyo.size()) {
                    map[j][i] = puyo.get(index++);
                } else map[j][i] = '.';
            }
        }
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}