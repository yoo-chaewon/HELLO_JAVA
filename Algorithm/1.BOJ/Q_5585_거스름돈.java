
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int money = 1000 - scanner.nextInt();
        int[] kinds = {500, 100, 50, 10, 5, 1};
        int answer = 0;


        for (int i = 0; i < kinds.length; i++){
            answer += money/kinds[i];
            money %= kinds[i];

        }
        System.out.println(answer);
    }
}


