import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class PrintQueue {
    public static void main(String[] args){
        try{
            PrintQueueMain();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //1966_printQueue
    public static void PrintQueueMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < num; i++){
            String f_line = bufferedReader.readLine();
            String sec_line = bufferedReader.readLine();
            PrintQueue(f_line, sec_line);
        }
    }
    public static void PrintQueue(String f_line, String sec_line){
        String[] MN_str = f_line.split(" ");
        String[] importance_str = sec_line.split(" ");
        int N = Integer.parseInt(MN_str[0]);
        int M = Integer.parseInt(MN_str[1]);
        int max = -1;
        int count = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> importance_queue = new LinkedList<>();
        for (int i = 0; i < N ; i++) {
            if (Integer.parseInt(importance_str[i]) > max){
                max = Integer.parseInt(importance_str[i]);
            }
            queue.add(i);
            importance_queue.add(Integer.parseInt(importance_str[i]));
        }
        while (true) {
            if (importance_queue.peekFirst() == max) {
                count++;
                if (queue.peekFirst() == M) {
                    System.out.println(count);
                    break;
                } else {
                    queue.pollFirst();
                    importance_queue.pollFirst();
                    max = -1;
                    for (int i = 0; i < importance_queue.size(); i++) {
                        if (importance_queue.get(i) > max) {
                            max = importance_queue.get(i);
                        }
                    }
                }
            } else {
                queue.add(queue.peekFirst());
                queue.pollFirst();
                importance_queue.add(importance_queue.peekFirst());
                importance_queue.pollFirst();
            }
        }
    }
}
