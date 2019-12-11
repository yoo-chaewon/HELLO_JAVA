import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String [] input = bufferedReader.readLine().split(" ");
        String A = input[0];
        String B = input[1];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - A.length(); i++){
            int count = 0;
            for (int j = 0 ; j < A.length(); j++){
                if (A.charAt(j) != B.charAt(j+i)) count++;
            }
            min = Math.min(min, count);
        }

        System.out.println(min);
    }

}


