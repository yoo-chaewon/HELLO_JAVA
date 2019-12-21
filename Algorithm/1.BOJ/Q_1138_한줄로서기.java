import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[] arr = new int[size];


        for (int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }

        int[] result = new int[size];
        for (int i = 0; i < size; i++){
            int curCount = arr[i];

            for (int j = 0; j < size; j++){
                if (result[j] == 0 && curCount-- == 0){
                    result[j] = i+1;
                    break;
                }
            }

        }

        for (int a : result){
            System.out.print(a + " ");
        }
    }
}
