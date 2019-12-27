import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int size;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());
        char[][] map1 = new char[size][size];
        char[][] map2 = new char[size][size];

        for (int i = 0; i < size; i++) {
            String temp = bufferedReader.readLine();
            for (int j = 0; j < size; j++) {
                map1[i][j] = temp.charAt(j);

                if (temp.charAt(j) == 'R'){
                    map2[i][j] = 'G';
                }else {
                    map2[i][j] = temp.charAt(j);
                }
            }
        }

        int count1 = 0;
        boolean[][] visited1 = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited1[i][j]) {
                    DFS(map1, visited1, j, i);
                    count1++;
                }
            }
        }

        int count2 = 0;
        boolean[][] visited2 = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited2[i][j]) {
                    DFS(map2, visited2, j, i);
                    count2++;
                }
            }
        }
        System.out.println(count1 +" " + count2);
    }

    public static void DFS(char[][] map, boolean[][] visited, int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];

            if (curX >= size || curY >= size || curX < 0 || curY < 0 || visited[curY][curX]) continue;

            if (map[y][x] == map[curY][curX]) {
                DFS(map,visited, curX, curY);
            }
        }
    }
}

