import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        BubbleSort(count, arr);

        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }

    public static  int[] BubbleSort(int count, int[] arr) {
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
}
