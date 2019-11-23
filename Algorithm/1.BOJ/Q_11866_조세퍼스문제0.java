import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Joseperse {
    public static void main(String[] args){
        try{
            JoseperseMain();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //11866
    public static void JoseperseMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Joseperse(input);
    }
    public static void Joseperse(String input){
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
