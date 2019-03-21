import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        try {
            obj.StackMain();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //10828
    static Stack<Integer> stack = new Stack<>();
    int top = 0;
    public void StackMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < num; i++){
            String input = bufferedReader.readLine();
            Stack(input);
        }
    }
    public void Stack(String input){
        String[] instruct = input.split(" ");

        switch (instruct[0]){
            case "push":
                top++;
                stack.push(Integer.parseInt(instruct[1]));
                break;
            case "pop":
                if (stack.empty() == false) {
                    top--;
                    System.out.println(stack.peek());
                    stack.pop();
                }else {
                    System.out.println(-1);
                }
                break;
            case "size":
                System.out.println(top);
                break;
            case "empty":
                if (stack.empty() == true){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
                break;
            case "top":
                if (stack.empty() == false){
                    System.out.println(stack.peek());
                }else {
                    System.out.println(-1);
                }
        }
    }
}
