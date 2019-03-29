import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Main obj = new Main();
        try {
            //obj.QueueBasicMain();
            //obj.PrintQueueMain();
            obj.JooMain();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //10845_Queue Basic
    LinkedList<String> queue_basic;

    public void QueueBasicMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lineNum = Integer.parseInt(bufferedReader.readLine());
        queue_basic = new LinkedList<>();


        for (int i = 0; i < lineNum; i++) {
            String command = bufferedReader.readLine();
            QueueBasic(queue_basic, command);
        }
    }

    public void QueueBasic(LinkedList<String> queue_basic, String command) {
        String[] mCommand = command.split(" ");

        switch (mCommand[0]) {
            case "push":
                queue_basic.add(mCommand[1]);
                break;
            case "pop":
                if (queue_basic.isEmpty() == true) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue_basic.pollFirst());
                }
                break;
            case "size":
                System.out.println(queue_basic.size());
                break;
            case "empty":
                if (queue_basic.isEmpty() == true) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                break;
            case "front":
                if (queue_basic.isEmpty() == true) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue_basic.peekFirst());
                }
                break;
            case "back":
                if (queue_basic.isEmpty() == true) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue_basic.peekLast());
                }
                break;
        }
    }

    //1966_printQueue
    public void PrintQueueMain() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < num; i++){
            String f_line = bufferedReader.readLine();
            String sec_line = bufferedReader.readLine();
            PrintQueue(f_line, sec_line);
        }
    }
    public void PrintQueue(String f_line, String sec_line){
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

    //11866
    public void JooMain() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Joo(input);
    }
    public void Joo(String input){
        String[] str = (input.split(" "));
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        LinkedList<Integer> joo_queue = new LinkedList<Integer>();
        LinkedList<Integer> result_queue = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++){
            joo_queue.add(i);
        }

        while (joo_queue.isEmpty() == false){
            for (int i = 0; i < M-1; i++){
                joo_queue.add(joo_queue.pollFirst());
            }
            result_queue.add(joo_queue.peekFirst());
            joo_queue.pollFirst();
        }

        System.out.print("<");
        for (int j = 0; j < result_queue.size(); j++){
            if (j == result_queue.size()-1){
                System.out.print(result_queue.get(j));
            }else {
                System.out.print(result_queue.get(j) + ", ");
            }
        }
        System.out.print(">");
    }
}
