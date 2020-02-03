import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            switch (cur) {
                case '(':
                    stack.push(-1);
                    break;
                case ')':
                    if (stack.peek() == -1) {//'('
                        stack.pop();
                        stack.push(1);
                    } else {
                        int tmp = 0;
                        while (stack.peek() != -1) {
                            tmp += stack.pop();
                        }
                        stack.pop();
                        answer += tmp + 1;
                        stack.push(tmp);
                    }
                    break;
            }
        }
        System.out.println(answer);
    }
}