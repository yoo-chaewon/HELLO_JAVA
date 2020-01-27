import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++){
            String[] input = bufferedReader.readLine().split(" ");
            switch (input[0]){
                case "push":
                    queue.add(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if (queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.pollFirst());
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
                    else System.out.println(queue.peekFirst());
                    break;
                case "back":
                    if (queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.peekLast());
                    break;
            }
        }
    }
}