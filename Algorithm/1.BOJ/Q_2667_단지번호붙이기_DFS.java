import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static boolean[][] visited;
    static int size;
    static int temp = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());

        int[][] map = new int[size][size];
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            String[] input = bufferedReader.readLine().split("");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int count = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    DFS(map, j, i);
                    count++;
                    answer.add(temp);
                    temp = 0;
                }
            }
        }
        System.out.println(count);
        Collections.sort(answer);
        for (int a: answer){
            System.out.println(a);
        }
    }

    public static void DFS(int[][] map, int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[y][x] = true;
        temp++;

        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];

            if (size <= curX || size <= curY || curX < 0 || curY < 0 || map[curY][curX] == 0 || visited[curY][curX])
                continue;
            DFS(map, curX, curY);
        }
    }
}


