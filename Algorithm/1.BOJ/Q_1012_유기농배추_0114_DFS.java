import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());
        while (testCase-- > 0){
            String[] input = bufferedReader.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N =Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);
            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++){
                String[] point = bufferedReader.readLine().split(" ");
                int x = Integer.parseInt(point[0]);
                int y = Integer.parseInt(point[1]);
                map[y][x] = 1;
            }

            int answer = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (map[i][j] == 1 && !visited[i][j]){
                        answer++;
                        DFS(j, i);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void DFS(int x, int y){
        visited[y][x] = true;

        for (int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || M <= nextX || N <= nextY || visited[nextY][nextX] || map[nextY][nextX] == 0) continue;
            DFS(nextX, nextY);
        }
    }
}
