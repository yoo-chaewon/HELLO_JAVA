import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] map;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean[] team = new boolean[N];
        makeTeam(0, 0, team);
        System.out.println(result);
    }

    public static void makeTeam(int start, int depth, boolean[] team) {
        if (depth == N / 2) {
            int startTeam = 0;
            int linkTeam = 0;
            for (int i = 0; i < N; i++) {
                if (team[i]) {
                    for (int j = 0; j < N; j++) {
                        if (team[j]) startTeam += map[i][j];
                    }
                } else {
                    for (int j = 0; j < N; j++) {
                        if (!team[j]) linkTeam += map[i][j];
                    }
                }
            }
            result = Math.min(result, Math.abs(startTeam - linkTeam));
            return;
        }

        for (int i = start; i < N; i++) {
            team[i] = true;
            makeTeam(i + 1, depth + 1, team);
            team[i] = false;
        }
    }
}