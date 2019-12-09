import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String N = bufferedReader.readLine();

        int[] arr = new int[N.length()];
        for (int i = 0; i < N.length(); i++){
            arr[i] = N.charAt(i)-'0';
        }
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 3 != 0 || arr[0] != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            stringBuilder.append(arr[i]);
        }
        System.out.println(stringBuilder);
    }
}


