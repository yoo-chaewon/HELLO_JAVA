import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int size;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        size = scanner.nextInt();
        map = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                map[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (map[i][j] == 1 && !visited[i][j]){
                    DFS(i, j, i);

                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void DFS(int top, int x, int y) {
        map[top][x] = 1;
        visited[top][x] = true;

        for (int i = 0; i < size; i++){
            if (map[x][i] == 1 && !visited[top][i])
                DFS(top, i, x);
        }
    }
}


