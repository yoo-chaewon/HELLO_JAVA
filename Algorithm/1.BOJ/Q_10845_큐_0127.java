import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    queue.offer(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if (queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.poll());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if (queue.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if (queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.peek());
                    break;
                case "back":
                    if (queue.isEmpty()) System.out.println(-1);
                    else {
                        int size = queue.size();
                        while (size-- > 1) {
                            queue.offer(queue.poll());
                        }
                        System.out.println(queue.peek());
                        queue.offer(queue.poll());
                    }
                    break;
            }
        }
    }
}