import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SequenceCalcul {
    public static void main(String[] args){
        try {
            SequenceCalculMain();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //2504
    public static void SequenceCalculMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        SequenceCalcul(input);
    }

    public static void SequenceCalcul(String input) {
        Stack<String> cal_stack = new Stack<String>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            if (result == -1){
                break;
            }
            String str = String.valueOf(input.charAt(i));
            switch (str) {
                case "(":
                    cal_stack.push(str);
                    break;
                case "[":
                    cal_stack.push(str);
                    break;
                case ")":
                    if (cal_stack.empty()){
                        break;
                    }
                    if (cal_stack.peek().equals("(")) {
                        cal_stack.pop();
                        cal_stack.push("2");
                    } else {
                        result = stackInnerFun(cal_stack, "[", "(", 2);
                    }
                    break;
                case "]":
                    if (cal_stack.empty()){
                        break;
                    }
                    if (cal_stack.peek().equals("[")) {
                        cal_stack.pop();
                        cal_stack.push("3");
                    } else {
                        result = stackInnerFun(cal_stack, "(", "[", 3);
                    }
                    break;
            }
        }
        int sum = 0;
        while (!cal_stack.empty()) {
            if (cal_stack.peek().equals("(") || cal_stack.peek().equals(")") || cal_stack.peek().equals("[") || cal_stack.peek().equals("]")) {
                sum = 0;
                break;
            } else {
                sum += Integer.parseInt(cal_stack.peek());
                cal_stack.pop();
            }
        }
        System.out.print(sum);
    }

    public static int stackInnerFun(Stack<String> in_stack, String input1, String input2, int value) {
        int result = 0;
        while (!in_stack.empty()) {
            String top = in_stack.peek();
            if (top.equals(input1)) {
                return -1;
            } else if (top.equals(input2)) {//만나면 끝나야 하니까 break
                in_stack.pop();
                result *= value;
                in_stack.push(String.valueOf(result));
                break;
            } else {//숫자인 경우
                result += Integer.parseInt(top);
                in_stack.pop();
            }
        }
        return result;
    }
}
