import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class QueueBasic {
    public static void main(String[] args) {
        try {
            QueueBasicMain();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //10845_Queue Basic
    static LinkedList<String> queue_basic;

    public static void QueueBasicMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lineNum = Integer.parseInt(bufferedReader.readLine());
        queue_basic = new LinkedList<>();

        for (int i = 0; i < lineNum; i++) {
            String command = bufferedReader.readLine();
            QueueBasic(queue_basic, command);
        }
    }

    public static void QueueBasic(LinkedList<String> queue_basic, String command) {
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
}
