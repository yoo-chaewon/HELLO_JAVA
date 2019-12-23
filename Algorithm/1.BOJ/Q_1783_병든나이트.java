import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        int N = scanner.nextInt();//세로
        int M = scanner.nextInt();//가로

        if (N == 1) System.out.println(1);
        else if (N == 2) System.out.println(Math.min((M+1)/2,4));
        else{
            if (M <= 6){
                System.out.println(Math.min(M, 4));
            }else{
                System.out.println( 4 + (M-6));
            }
        }
    }
}
