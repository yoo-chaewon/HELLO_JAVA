import java.util.Scanner;

public class InsertSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        InsertSort(count, arr);

        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] InsertSort(int count, int[] arr){
        int key;
        for (int i = 1 ; i < count ; i++){
            key = arr[i];
            for (int j = i-1; j >= 0; j--){
                if (arr[j] > key){
                    arr[j+1] = arr[j];
                    arr[j] = key;
                }
                else break;
            }
        }
        return  arr;
    }
}
