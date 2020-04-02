import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = i;

        NM(arr, M, 1, 0, "");
    }

    public static void NM(int[] arr, int M, int start, int depth, String result) {
        if (depth == M) {
            System.out.println(result);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            NM(arr, M, i, depth + 1, result + arr[i] + " ");
        }
    }
}