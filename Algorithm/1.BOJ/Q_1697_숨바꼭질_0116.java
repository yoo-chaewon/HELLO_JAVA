import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int MAX = 100000;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);//수빈위치
        int K = Integer.parseInt(input[1]);//동생위치
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        int[] map = new int[MAX + 1];
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (temp == K){
                System.out.print(map[temp]);
                return;
            }
            int[] next = new int[3];
            next[0] = temp - 1;
            next[1] = temp + 1;
            next[2] = temp * 2;

            for (int i = 0; i < 3; i++) {
                if (next[i] < 0 || next[i] > MAX || map[next[i]] != 0) {
                    continue;
                }
                map[next[i]] = map[temp] + 1;
                queue.add(next[i]);
            }
        }
    }
}
