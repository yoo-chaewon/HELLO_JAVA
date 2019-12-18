import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[] arr = new int[size];
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        int index = 0;
        answer[0] = arr[0];
        for (int i = 1 ; i < size; i++){
            if (answer[index] < arr[i]){
                answer[++index] = arr[i];
            }else{
                int temp = Arrays.binarySearch(answer, 0, index, arr[i]);
                if (temp < 0){
                    answer[temp * -1 -1] = arr[i];
                }else {
                    answer[temp] = arr[i];
                }
            }
        }
        System.out.println(index+1);
    }
}
