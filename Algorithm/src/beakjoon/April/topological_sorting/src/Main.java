import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        try {
            obj.HeightMain();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void HeightMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);//수
        int M = Integer.parseInt(input[1]);//간선

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        int[] count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            String[] str = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            list[a].add(b);
            count[b]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int temp = queue.peek();
            System.out.print(temp + " ");
            queue.poll();

            for (int i = 0; i < list[temp].size(); i++) {
                int next = list[temp].get(i);
                count[next]--;
                if (count[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
