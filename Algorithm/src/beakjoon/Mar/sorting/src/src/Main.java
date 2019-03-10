import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        Main obj = new Main();
        //obj.SelectSort(count, arr);
        //obj.BubbleSort(count, arr);
        obj.InsertSort(count, arr);


        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] SelectSort(int count, int[] arr) {
        int temp;

        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public int[] BubbleSort(int count, int[] arr) {
        int temp;

        for (int i = 1; i < count; i++) {
            for (int j = 0; j < count - i; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public int[] InsertSort(int count, int[] arr){
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
