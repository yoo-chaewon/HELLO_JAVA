import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int mapSize = 5;
    static int resultSize = 6;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static HashSet<String> result = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        map = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                DFS(j, i, String.valueOf(map[i][j]));
            }
        }
        System.out.println(result.size());
    }

    public static void DFS(int x, int y, String str) {
        if (str.length() == resultSize) {
            result.add(str);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= mapSize || nextY < 0 || nextY >= mapSize ) continue;
            DFS(nextX, nextY, str + map[nextY][nextX]);
        }
    }
}