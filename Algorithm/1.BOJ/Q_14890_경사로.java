import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static boolean[][] visited1;
    static boolean[][] visited2;
    static int N;// 지도 길이
    static int L;// 경사로 길이

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        N = scanner.nextInt();
        L = scanner.nextInt();
        map = new int[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int answer = 0;
        //가로 검
        for (int i = 0; i < N; i++) {
            int pre = map[i][0];
            answer++;
            for (int j = 1; j < N; j++) {
                if (pre != map[i][j]) {
                    if (pre - map[i][j] < 0) {//오르막
                        if (!upper(map[i][j], j, i, 0)) {
                            answer--;
                            break;
                        }
                    } else {//내리막
                        if (!lower(map[i][j - 1], j-1, i, 0)) {
                            answer--;
                            break;
                        } else {
                            j += L - 1;
                        }
                    }
                }
                pre = map[i][j];
            }
        }

        //세로 검사
        for (int j = 0; j < N; j++) {
            int pre = map[0][j];
            answer++;
            for (int i = 1; i < N; i++) {
                if (pre != map[i][j]) {
                    if (pre - map[i][j] < 0) {//오르막
                        if (!upper(map[i][j], j, i, 1)) {
                            answer--;
                            break;
                        }
                    } else {//내리막
                        if (!lower(map[i - 1][j], j, i - 1, 1)) {
                            answer--;
                            break;
                        } else {//성공
                            i += L - 1;
                        }
                    }
                }
                pre = map[i][j];
            }
        }
        System.out.print(answer);
    }

    //dir:0 - 가로방향, dir:1 - 세로방향
    public static boolean upper(int cur, int x, int y, int dir) {//오르막 경사
        if (dir == 0) {
            if (x - L < 0) return false;
            for (int i = 1; i <= L; i++) {
                if (map[y][x - i] != cur - 1 || visited1[y][x - i]) return false;
                visited1[y][x - i] = true;
            }
        } else {
            if (y - L < 0) return false;
            for (int i = 1; i <= L; i++) {
                if (map[y - i][x] != cur - 1 || visited2[y - i][x]) return false;
                visited2[y - i][x] = true;
            }
        }
        return true;
    }

    public static boolean lower(int cur, int x, int y, int dir) {//내리막 경사로
        if (dir == 0) {
            if (x + L >= N) return false;
            for (int i = 1; i <= L; i++) {
                if (map[y][x + i] != cur - 1 || visited1[y][x + i]) return false;
                visited1[y][x + i] = true;
            }
        } else {
            if (y + L >= N) return false;
            for (int i = 1; i <= L; i++) {
                if (map[y + i][x] != cur - 1 || visited2[y + i][x]) return false;
                visited2[y + i][x] = true;
            }
        }
        return true;
    }
}
