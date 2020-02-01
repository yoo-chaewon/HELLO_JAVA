import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());

            if (n == 0){
                stack.pop();
            }else {
                stack.push(n);
            }
        }
        int answer = 0;
        while (!stack.isEmpty()){
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}
