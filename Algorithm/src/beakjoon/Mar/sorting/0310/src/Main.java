import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int size = input.length();
        char[] arr = new char[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.charAt(i);
        }

        Main obj = new Main();
        obj.BubbleSort(size, arr);

        for (int i = 0; i <size; i++){
            System.out.print(arr[i]);
        }
    }
    public char[] BubbleSort(int size, char[] arr){
        int temp;
        for (int i = 1; i < size; i++){
            for (int j = 0; j < size-i; j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = (char)temp;
                }
            }
        }
        return arr;
    }
}
