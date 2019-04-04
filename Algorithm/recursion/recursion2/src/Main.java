import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        try {
            obj.gameMain();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //1103
    Integer[][] map;
    int N, M;

    public void gameMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input[] = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new Integer[N][M];
        String[] str = new String[M];
        for (int i = 0; i < N; i++) {
            str[i] = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                if (str[i].charAt(j) == 'H') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = str[i].charAt(j) - '0';
                }
            }
        }
        int[][] visited = new int[N][M];
        game(0, 0, 1, visited);
        Collections.sort(max);
        if (max.get(0) == -1) {
            System.out.println(-1);
        } else {
            System.out.println(max.get(max.size() - 1));
        }
    }

    ArrayList<Integer> max = new ArrayList<>();
    public void game(int a, int b, int count, int[][] visited) {
        if ((a < 0 || N - 1 < a || b < 0 || M - 1 < b)) {//박스 밖
            count--;
            max.add(count);
        } else if (visited[a][b] == 1) {
            max.add(-1);
        } else {
            int num = map[a][b];
            if (num == 0) {
                count--;
            } else {
                count++;
                visited[a][b] = 1;
                game(a + num, b, count, visited);
                game(a - num, b, count, visited);
                game(a, b + num, count, visited);
                game(a, b - num, count, visited);
            }
        }
    }
}
