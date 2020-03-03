import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int testCase = 10;

        for (int t = 0; t < testCase; t++) {
            int answer = 0;
            int size = scanner.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++){
                arr[i] = scanner.nextInt();
            }

            for (int i = 2; i < size-2; i++){
                int result = check(arr,i);
                if (result != -1) {
                    answer+=result;
                }
            }
            System.out.println("#"+(t+1) + " " + answer);
        }
    }

    public static int check(int[] arr, int curIndex){
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 2; i++){
            if (arr[curIndex] < arr[curIndex+i]) return -1;
            if (arr[curIndex] < arr[curIndex-i]) return -1;
            max = Math.max(max, arr[curIndex+i]);
            max = Math.max(max, arr[curIndex-i]);
        }
        return arr[curIndex]-max;
    }
}
