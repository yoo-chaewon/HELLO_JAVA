import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        StringTokenizer str = new StringTokenizer(bufferedReader.readLine());
        int[] map = new int[N];
        for (int i = 0; i < N; i++){
            map[i] = Integer.parseInt(str.nextToken());
        }

        int result = 0;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (true){
            if (sum >= M) sum -= map[start++];
            else if (end > N-1) break;
            else sum += map[end++];

            if (sum == M) result++;
        }
        System.out.println(result);

    }
}