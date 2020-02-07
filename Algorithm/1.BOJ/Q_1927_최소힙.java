import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        while (size -- > 0){
            int num = Integer.parseInt(bufferedReader.readLine());
            if (num == 0){
                if (queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            }else{
                queue.add(num);
            }
        }
    }
}