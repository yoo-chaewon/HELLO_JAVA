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
            //System.out.println("+");

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
    public void SequenceCalculMain() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        SequenceCalcul(input);
    }
    public void SequenceCalcul(String input){
        Stack<String> cal_stack = new Stack<String>();
        int result = 0;
        int result1 = 0;
        int result2 = 0;
        int last_result = 0;

        for (int i = 0; i < input.length(); i++){
            if (cal_stack.empty() == true){
                result1 = 0;
                result2 = 0;
                result = 0;
            }
            String get_str = String.valueOf(input.charAt(i));

            if (get_str.equals("(")){
                cal_stack.push(get_str);
            }else if (get_str.equals(")")){
                if (cal_stack.peek().equals("(") && cal_stack.size() > 1){
                    cal_stack.pop();
                    if (result1 == 0){
                        result1 = 2;
                    }else {
                        result1 *= 2;
                    }
                }else if(cal_stack.peek().equals("(") && cal_stack.size() == 1){
                        cal_stack.pop();
                        result = result1 + result2;

                }
            }else if (get_str.equals("[")){
                cal_stack.push(get_str);
            }else if (get_str.equals("]")){
                if (cal_stack.peek().equals("[") && cal_stack.size() > 1){
                    cal_stack.pop();
                    if (result2 == 0){
                        result2 = 3;
                    }else {
                        result2 *= 3;
                    }
                }else if(cal_stack.peek().equals("[") && cal_stack.size() == 1){
                    cal_stack.pop();
                    result = result1 + result2;
                }
            }
            if (result != 0) {

                    last_result += result;

            }
        }
        System.out.println(last_result);
    }
}
