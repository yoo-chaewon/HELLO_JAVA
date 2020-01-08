import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++){
            max = Math.max(max, arr[N-i] * i);
        }

        System.out.println(max);

    }
}
