import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("-");
        int answer = innerCal(input[0]);
        for (int i = 1; i < input.length; i++){
            answer += innerCal(input[i]) * -1;
        }
        System.out.println(answer);
    }

    public static int innerCal(String str){
        String[] input = str.split("\\+");
        int sum = 0;

        for (int i = 0; i < input.length; i++){
            sum += Integer.parseInt(input[i]);
        }
        return sum;
    }
}
