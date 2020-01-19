import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int size;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args){
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
                    DFS(i, j);
                }
            }
        }
        Print(map);
    }

    public static void DFS(int top, int point){
        visited[top][point] = true;
        for (int i = 0; i < size; i++){
            if (map[point][i] == 1 && !visited[top][i]){
                map[top][i] = 1;
                DFS(top, i);
            }
        }

    }

    public static void Print(int[][] map){
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
