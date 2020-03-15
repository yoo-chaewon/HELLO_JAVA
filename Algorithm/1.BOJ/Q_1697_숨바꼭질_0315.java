import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int MAX = 100000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] map = new int[MAX + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == K) {
                System.out.println(map[cur]);
                return;
            }

            int[] nextN = new int[3];
            nextN[0] = cur + 1;
            nextN[1] = cur - 1;
            nextN[2] = cur * 2;

            for (int i = 0; i < 3; i++) {
                if (nextN[i] < 0 || nextN[i] > MAX || map[nextN[i]] != 0) continue;
                map[nextN[i]] = map[cur] + 1;
                queue.add(nextN[i]);
            }
        }
    }
}


