import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);//끊어진
        int M = Integer.parseInt(input[1]);//브랜드

        int set = 1000;
        int per = 1000;
        for (int i = 0 ; i < M ; i++){
            String[] val = bufferedReader.readLine().split(" ");
            set = Math.min(set, Integer.parseInt(val[0]));
            per = Math.min(per, Integer.parseInt(val[1]));
        }

        int setNum = N / 6;
        int perNum = N % 6;

        int answer = Math.min((setNum + 1) * set, Math.min(N * per, setNum * set + perNum * per));
        System.out.println(answer);
    }
}
