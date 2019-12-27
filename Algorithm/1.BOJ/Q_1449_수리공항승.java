import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int N = scanner.nextInt();//물이 새는 곳 개수
        int L = scanner.nextInt();//테이프 길이

        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int count = 1;
        int cur = arr[0];
        for (int i = 0; i < N; i++){
            if (!(cur + L -1 >= arr[i])){
                count++;
                cur = arr[i];
            }
        }
        System.out.println(count);
    }
}
