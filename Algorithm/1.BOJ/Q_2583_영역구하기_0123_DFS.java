import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] MNK = bufferedReader.readLine().split(" ");
        M = Integer.parseInt(MNK[0]);
        N = Integer.parseInt(MNK[1]);
        int K = Integer.parseInt(MNK[2]);

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int k = 0; k < K; k++){
            String[] input = bufferedReader.readLine().split(" ");
            int upperX = Integer.parseInt(input[0]);
            int upperY = Integer.parseInt(input[1]);
            int downX = Integer.parseInt(input[2]);
            int downY = Integer.parseInt(input[3]);

            for (int i = upperY; i < downY; i++){
                for (int j = upperX; j < downX; j++){
                    map[i][j] = 1;
                }
            }
        }

        int answer = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                if (map[i][j] == 0 && !visited[i][j]){
                    answer++;
                    DFS(j, i);
                    result.add(count);
                    count = 0;
                }
            }
        }
        System.out.println(answer);
        Collections.sort(result);
        for (int a : result) System.out.print(a + " ");
    }

    public static void DFS(int x, int y){
        visited[y][x] = true;
        count++;

        for (int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || visited[nextY][nextX] || map[nextY][nextX] != 0) continue;
            DFS(nextX, nextY);
        }
    }
}
