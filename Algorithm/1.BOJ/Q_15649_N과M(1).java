import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = i;
        boolean[] visited = new boolean[N + 1];

        NM(arr, M, visited, 0, "");
    }

    public static void NM(int[] arr, int M, boolean[] visited, int depth, String result) {
        if (depth == M) {
            System.out.println(result);
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                NM(arr, M, visited, depth + 1, result + arr[i] + " ");
                visited[i] = false;
            }
        }
    }
}


