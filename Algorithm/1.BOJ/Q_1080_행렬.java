import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

public class Main {
    static int N;
    static int M;
    static int[][] map1;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        N = parseInt(input[0]);
        M = parseInt(input[1]);

        map1 = new int[N][M];
        int[][] map2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] tmp = bufferedReader.readLine().split("");
            for (int j = 0; j < M; j++) {
                map1[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            String[] tmp = bufferedReader.readLine().split("");
            for (int j = 0; j < M; j++) {
                map2[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map1[i][j] != map2[i][j]) {
                    if (change(j, i)){
                        answer++;
                    }else {
                        System.out.println(-1);
                        return;
                    }

                }
            }
        }
        System.out.println(answer);
    }

    public static boolean change(int x, int y) {
        if (x + 3 > M || y + 3 > N) return false;
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                if (map1[i][j] == 0) map1[i][j] = 1;
                else map1[i][j] = 0;
            }
        }
        return true;
    }
}


