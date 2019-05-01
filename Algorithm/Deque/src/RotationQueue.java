import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//1021
public class RotationQueue {
    static int count = 0;
    static int N;
    static int M;
    static LinkedList<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer NM = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(NM.nextToken());
        M = Integer.parseInt(NM.nextToken());
        StringTokenizer findnum = new StringTokenizer(bufferedReader.readLine());

        queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        for (int i = 0; i < M; i++) {
            RotationQueue(Integer.parseInt(findnum.nextToken()));
        }
        System.out.println(count);
    }

    public static void RotationQueue(int number) {
        while (true) {
            int num_index = queue.indexOf(number);
            int queue_mid = queue.size() / 2;
            if (num_index <= queue_mid) {
                int tmp_front = queue.pollFirst();
                if (tmp_front == number) {
                    break;
                }
                queue.addLast(tmp_front);
                count++;
            } else {
                int tmp_last = queue.pollLast();
                queue.addFirst(tmp_last);
                count++;
            }
        }
    }
}
