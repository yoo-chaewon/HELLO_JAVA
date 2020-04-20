import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int max = 0;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(input.nextToken());
        M = Integer.parseInt(input.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                Find(visited, j, i, 1, map[i][j]);
                visited[i][j] = false;
                max = Math.max(max, ExceptionShape(j, i));
            }
        }
        System.out.println(max);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void Find(boolean[][] visited, int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || visited[nextY][nextX]) continue;
            visited[nextY][nextX] = true;
            Find(visited, nextX, nextY, depth + 1, sum + map[nextY][nextX]);
            visited[nextY][nextX] = false;
        }
    }

    public static int ExceptionShape(int x, int y) {
        int size = 1;
        int sum = map[y][x];
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N ) continue;
            size++;
            sum += map[nextY][nextX];
            minValue = Math.min(minValue, map[nextY][nextX]);
        }

        if (size == 4) return sum;
        else if (size == 5) return sum - minValue;
        else return 0;
    }
}
