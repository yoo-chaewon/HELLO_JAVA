import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX_N = 50;
    static int[] groupArr ;
    static int[] sumArr ;
    static int[][] map;
    static int groupCount = 0;
    static int[][] groupMap;
    static int N;
    static int L;
    static int R;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(input.nextToken());
        L = Integer.parseInt(input.nextToken());
        R = Integer.parseInt(input.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        int result = 0;
        while (true) {
            groupCount = 0;
            groupMap = new int[N][N];
            groupArr = new int[MAX_N * MAX_N + 1];
            sumArr = new int[MAX_N * MAX_N + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (groupMap[i][j] == 0) {
                        groupCount++;
                        DFS(j, i);
                    }
                }
            }
            Update();
            if (N*N == groupCount) break;
            result++;
        }
        System.out.println(result);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void DFS(int x, int y) {
        groupMap[y][x] = groupCount;
        groupArr[groupCount]++;
        sumArr[groupCount] += map[y][x];

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || groupMap[nextY][nextX] != 0) continue;
            int diff = Math.abs(map[y][x] - map[nextY][nextX]);
            if (diff < L || diff > R) continue;
            DFS(nextX, nextY);
        }
    }

    public static void Update(){
        for (int i = 0; i < N; i++){
            for (int j = 0;  j < N; j++){
                int myGroup = groupMap[i][j];
                map[i][j] = sumArr[myGroup]/groupArr[myGroup];
            }
        }
    }
}
