import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if ('A' <= cur && cur <= 'Z') {
                System.out.print(cur);
            } else {
                if (cur == '(') {
                    stack.push(cur);
                } else if (cur == ')') {
                    while (stack.peek() != '(') {
                        System.out.print(stack.pop());
                    }
                    stack.pop();
                } else {//operator
                    while (!stack.isEmpty() && priorityOP(cur) <= priorityOP(stack.peek())) {
                        System.out.print(stack.pop());
                    }
                    stack.push(cur);
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static int priorityOP(Character op) {
        if (op == '(' || op == ')') return 0;
        else if (op == '+' || op == '-') return 1;
        else return 2;
    }
}