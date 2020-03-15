import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int MAX = 100001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] dist = new int[MAX + 1];//최단값 누적
        int[] count = new int[MAX + 1];//방법수
        boolean[] visited = new boolean[MAX + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        count[N] = 1;
        visited[N] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : new int[]{cur + 1, cur - 1, cur * 2}) {
                if (next < 0 || next > MAX) continue;
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    count[next] = count[cur];
                    queue.add(next);
                } else if (dist[next] == dist[cur] + 1) {
                    count[next]+= count[cur];
                }
            }
        }
        System.out.println(dist[K]);
        System.out.println(count[K]);
    }
}




