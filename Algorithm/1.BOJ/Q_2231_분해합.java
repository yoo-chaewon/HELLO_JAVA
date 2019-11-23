import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine());
        for (int i = 1 ; i <= 1000000; i++){
            int sum = 0;
            int temp = i;
            while (temp > 0){
                sum += temp % 10;
                temp = temp/10;
            }
            sum = sum + i;

            if (sum == input){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
