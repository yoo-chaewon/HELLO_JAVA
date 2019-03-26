import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        try {
            //obj.StackMain();
            //obj.VPSMain();
            //obj.SequenceStackMain();
            obj.SequenceCalculMain();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //10828
    static Stack<Integer> stack = new Stack<>();
    int top = 0;

    public void StackMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < num; i++) {
            String input = bufferedReader.readLine();
            Stack(input);
        }
    }

    public void Stack(String input) {
        String[] instruct = input.split(" ");

        switch (instruct[0]) {
            case "push":
                top++;
                stack.push(Integer.parseInt(instruct[1]));
                break;
            case "pop":
                if (stack.empty() == false) {
                    top--;
                    System.out.println(stack.peek());
                    stack.pop();
                } else {
                    System.out.println(-1);
                }
                break;
            case "size":
                System.out.println(top);
                break;
            case "empty":
                if (stack.empty() == true) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                break;
            case "top":
                if (stack.empty() == false) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
        }
    }

    //9012
    public void VPSMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < num; i++) {
            String input = bufferedReader.readLine();
            VPS(input);
        }

    }

    public void VPS(String input) {
        Stack<Character> vps_stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            String bracket = String.valueOf(input.charAt(i));
            if (bracket.equals("(")) {
                vps_stack.push(input.charAt(i));
            } else {//)
                if (vps_stack.size() > 0) {//안에 있을 때
                    vps_stack.pop();
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (vps_stack.size() > 0) System.out.println("NO");
        else System.out.println("YES");
    }

    //1874
    public void SequenceStackMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        SequenceStack(arr);
    }

    public void SequenceStack(int[] arr) {
        Stack<Integer> seq_stack = new Stack<>();
        int arr_cur = 0;
        ArrayList<String> result = new ArrayList<>();

        for (int i = 1; i < arr.length + 1; i++) {
            seq_stack.push(i);
            result.add("+");
            while (arr[arr_cur] == seq_stack.peek()) {
                seq_stack.pop();
                result.add("-");
                arr_cur += 1;

                if (seq_stack.empty() == true) {
                    break;
                }
            }
        }
        if (seq_stack.empty() == false) {
            System.out.println("NO");
        } else {
            for (String str : result) {
                System.out.println(str);
            }
        }
    }

    //2504
    public void SequenceCalculMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        SequenceCalcul(input);
    }

    public void SequenceCalcul(String input) {
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

    public int stackInnerFun(Stack<String> in_stack, String input1, String input2, int value) {
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
