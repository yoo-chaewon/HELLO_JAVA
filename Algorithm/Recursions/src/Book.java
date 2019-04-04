import java.io.IOException;
import java.util.Scanner;

public class Book {
    public static void main(String[] args){
        try{
            BookMain();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //1019
    public static void BookMain() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] arr = new int[10];

        for (int i : Book(N, arr)) {
            System.out.print(i + " ");
        }
    }

    public static int[] Book(int N, int[] arr) {
        if (N <= 0) {
            return arr;
        }
        if (N < 10) {
            arr[N] += 1;
            Book(N - 1, arr);
            return arr;
        } else {
            if (N % 10 == 0) {
                arr[0] += 1;
                Book(N / 10, arr);
                Book(N - 1, arr);
            } else {
                Book(N / 10, arr);
                Book(N % 10, arr);
                Book(N - 1, arr);
            }
        }
        return arr;
    }
}
