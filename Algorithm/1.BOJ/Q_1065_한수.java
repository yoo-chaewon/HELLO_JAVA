import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1065 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine());
        int count = 0;

        for (int i = 1; i <= input; i++) {
            int temp = i;
            int len = (int) Math.log10(i) + 1;
            if (len < 3) {
                count++;
                continue;
            }
            int sub = 10;
            int j;
            for (j = 0; j < len-1; j++) {
                int diff = (temp%10) - (temp/10%10);
                temp = temp/10;
                if (diff != sub && sub !=10){
                    break;
                }
                sub = diff;
            }
            if (j == len -1){
                count++;
            }
        }
        System.out.println(count);
    }
}
