import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//10866
public class DequeBasic {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lineNum = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < lineNum; i++) {
            DequeBasic(bufferedReader.readLine());
        }
    }
    static Deque<Integer> deque = new ArrayDeque<>();
    public static void DequeBasic(String input) {
        String[] minput = input.split(" ");
        switch (minput[0]){
            case "push_front":
                deque.addFirst(Integer.parseInt(minput[1]));
                break;
            case "push_back":
                deque.addLast(Integer.parseInt(minput[1]));
                break;
            case "pop_front":
                if (deque.size() > 0){
                    System.out.println(deque.pollFirst());
                }else {
                    System.out.println(-1);
                }
                break;
            case "pop_back":
                if (deque.size() > 0){
                    System.out.println(deque.pollLast());
                }else {
                    System.out.println(-1);
                }
                break;
            case "size":
                System.out.println(deque.size());
                break;
            case "empty":
                if (deque.isEmpty()){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
                break;
            case "front":
                if (deque.size() > 0){
                    System.out.println(deque.peekFirst());
                }else {
                    System.out.println(-1);
                }
                break;
            case "back":
                if (deque.size() > 0){
                    System.out.println(deque.peekLast());
                }else {
                    System.out.println(-1);
                }
                break;
        }

    }
}
