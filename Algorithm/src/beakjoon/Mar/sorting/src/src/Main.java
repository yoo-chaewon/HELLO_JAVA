import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];

        for (int i = 0; i < count; i++){
            arr[i] = sc.nextInt();
        }
        Main obj = new Main();
        obj.SelectSort(count, arr);


        for (int i = 0 ; i < count; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] SelectSort(int count, int[] arr){
        int cur_x = 0;
        int cur_m = cur_x + 1;
        int temp;

        for (int i = 0; i < count; i++){
            for (int j = i+1 ; j < count; j++){
                if (arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
