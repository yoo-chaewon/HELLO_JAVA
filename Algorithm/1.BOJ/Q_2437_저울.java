import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        int min = 1;

        for (int i = 0; i < size; i++){
            if (min < arr[i]) break;
            min += arr[i];
        }
        System.out.println(min);
    }
}
