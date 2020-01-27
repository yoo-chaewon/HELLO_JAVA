import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < N; i++){
            String[] input = bufferedReader.readLine().split(" ");

            switch (input[0]){
                case "push":
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if (stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "top":
                    if (stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.peek());
                    break;
            }
        }
    }
}