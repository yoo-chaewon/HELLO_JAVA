import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    //북동남서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int N, M;
    static int[][] map;
    static int count = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        String[] input = bufferedReader.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int d = Integer.parseInt(input[2]);

        map = new int[N][M];
        for (int i = 0; i < N; i++){
            String[] line = bufferedReader.readLine().split(" ");
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        DFS(c, r, d);
        System.out.println(count);
    }

    public static void DFS(int x, int y, int dir){
        map[y][x] = 5;//visited

        for (int i = 0; i < 4; i++){
            dir = ((3+dir) ) % 4;
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            if (nextX < 0 || nextY < 0 || M <= nextX || N <= nextY || map[nextY][nextX] != 0) continue;
            count++;
            DFS(nextX, nextY, dir);
            return;
        }

        int backDir = (dir + 2) % 4;
        int backX = x + dx[backDir];
        int backY = y + dy[backDir];
        if (0 <= backX && 0 <= backY && backX < M && backY < N && map[backY][backX] != 1){
            DFS(backX, backY, dir);
        }
    }
}