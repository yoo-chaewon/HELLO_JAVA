import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int lotto = 6;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = -1;
        while ((size = scanner.nextInt()) != 0){
            int[] map = new int[size];
            int[] result = new int[lotto];

            for (int i = 0; i < size; i++){
                map[i] = scanner.nextInt();
            }

            DFS(0, 0, map, result);
            System.out.println();
        }
    }

    public static void DFS(int start, int depth, int[] map, int[]result){
        if (depth == lotto){
            for (int i = 0; i < lotto; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < map.length; i++){
            result[depth] = map[i];
            DFS(i+1, depth+1, map, result);
        }
    }
}