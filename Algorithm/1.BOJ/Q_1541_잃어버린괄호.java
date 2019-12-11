import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("-");
        int answer = resultStr(input[0]);

        for (int i = 1; i < input.length; i++){
            answer -= resultStr(input[i]);
        }

        System.out.println(answer);
    }
    public static int resultStr(String str){
        String[] arr = str.split("\\+");
        int number = 0;
        for (int j = 0; j < arr.length; j++) {
            number += Integer.parseInt(arr[j]);
        }
        return number;
    }
}


