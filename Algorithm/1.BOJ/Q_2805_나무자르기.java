import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());
        int[] trees = new int[N];
        input = new StringTokenizer(bufferedReader.readLine());

        long left = 0;
        long right = 0;
        long mid = 0;
        long answer = 0;

        for (int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(input.nextToken());
            right = Math.max(right, trees[i]);
        }

        while (left <= right){
            mid = (left + right) / 2;

            long sum = 0;
            for (int tree : trees) if (tree >=  mid) sum += (tree - mid);

            if (sum < M) right = mid - 1;
            else {
                left = mid + 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}