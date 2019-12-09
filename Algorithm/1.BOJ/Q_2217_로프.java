import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int max = Integer.MIN_VALUE;

        Arrays.sort(arr);
        for (int i = N-1; i >= 0; i--){
            max = Math.max(max, arr[i] * (N-i));
        }

        System.out.println(max);
    }
}