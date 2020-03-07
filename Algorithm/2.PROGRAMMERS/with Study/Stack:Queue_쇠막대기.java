import java.util.Stack;

class Solution {
    public static int solution(String arrangement) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arrangement.length(); i++) {
            char cur = arrangement.charAt(i);
            switch (cur) {
                case '(':
                    stack.push(-1);
                    break;
                case ')':
                    if (stack.peek() == -1) {
                        stack.pop();
                        stack.push(1);
                    } else {
                        int tmp = 0;
                        while (stack.peek() != -1) {
                            tmp += stack.pop();
                        }
                        stack.pop();
                        stack.push(tmp);
                        answer += tmp + 1;
                    }
                    break;
            }
        }
        return answer;
    }
}