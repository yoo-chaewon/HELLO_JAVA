import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Q_1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);//문제 수
        int M = Integer.parseInt(input[1]);//간선 수
        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        int[] count = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            String[] problem = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(problem[0]);
            int b = Integer.parseInt(problem[1]);
            arr[a].add(b);
            count[b]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");

            for (int i = arr[temp].size() - 1; i >= 0; i--) {
                int next = arr[temp].get(i);
                count[next]--;
                if (count[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
