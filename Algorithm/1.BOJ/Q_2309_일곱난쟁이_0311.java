import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = 9;
        int sum = 0;
        int[] arr = new int[size];

        for (int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < size-1; i++){
            for (int j = i+1; j < size; j++){
                if (sum - arr[i] - arr[j] == 100){
                    for (int a : arr){
                        if ((a != arr[i]) &&( a != arr[j])){
                            System.out.println(a);
                        }
                    }
                    return;
                }
            }
        }
    }
}