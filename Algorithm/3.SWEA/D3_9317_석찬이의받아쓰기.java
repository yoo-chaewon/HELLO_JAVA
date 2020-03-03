import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int testCase = scanner.nextInt();

        for (int t = 0; t < testCase; t++){
            int strSize = scanner.nextInt();
            String str1 = scanner.next();
            String str2 = scanner.next();
            int answer = 0;

            for (int i = 0; i < strSize; i++){
                if (str1.charAt(i) == str2.charAt(i)) answer++;
            }
            System.out.println("#" + (t+1) + " " + answer);
        }
    }
}