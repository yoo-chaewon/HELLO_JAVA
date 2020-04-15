import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] T = new int[N+2];
        int[] P = new int[N+2];
        int[] dp = new int[N+2];
        for (int i = 0; i < N; i++){
            String[] input = bufferedReader.readLine().split(" ");
            T[i+1] = Integer.parseInt(input[0]);
            P[i+1] = Integer.parseInt(input[1]);
        }

        int result = 0;
        for (int i = 1; i <= N; i++){
            if (i + T[i] <= N+1){
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i]+P[i]);
                result = Math.max(result, dp[i+T[i]]);
            }
            dp[i+1] = Math.max(dp[i], dp[i+1]);
            result = Math.max(dp[i+1], result);

        }
        System.out.println(result);
    }
}
