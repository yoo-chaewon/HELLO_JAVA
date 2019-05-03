import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1038 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine());
        int count = 0;

        if (input > 1022) System.out.println("-1");
        else if (input == 1022) System.out.println("9876543210");
        else {
            for (long i = 0; ; i++) {
                long temp = i;
                int len = (int) Math.log10(i) + 1;
                if (count == input) {
                    System.out.print(i);
                    return;
                }
                count++;
                for (int j = 0; j < len - 1; j++) {
                    if ((temp % 10 - temp / 10 % 10) >= 0) {
                        count--;
                        break;
                    }
                    temp = temp / 10;
                }
            }
        }
    }
}
