import java.io.InputStreamReader;
import java.util.Scanner;

public class SWE {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int test = scanner.nextInt();
        for (int i = 0; i < test; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a < b){
                System.out.println("#" + i+1 + " <");
            }else if (a == b){
                System.out.println("#" + i+1 + " =");
            }else {
                System.out.println("#" + i+1 + " >");
            }
        }
    }
}
