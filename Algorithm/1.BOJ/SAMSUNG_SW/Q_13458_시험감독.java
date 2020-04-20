import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] room = new int[N];
        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < N ; i++) room[i] = Integer.parseInt(input[i]);
        String[] BC = bufferedReader.readLine().split(" ");
        int B = Integer.parseInt(BC[0]);
        int C = Integer.parseInt(BC[1]);

        long answer = 0;
        for (int a : room){
            answer++;
            a -= B;
            if (a > 0){
                if (a % C == 0) answer += (a/C);
                else answer += (a / C) + 1;
            }
        }
        System.out.println(answer);
    }
}
