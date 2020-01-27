import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0){
            String input = bufferedReader.readLine();
            if (Check(input)) System.out.println("YES");
            else System.out.println("NO");

        }
    }

    public static boolean Check(String input){
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++){
            switch (input.charAt(i)){
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (!stack.isEmpty()){
                        stack.pop();
                    }else {
                        return false;
                    }
                    break;
            }
        }
        if (!stack.isEmpty()) answer= false;
        return answer;
    }
}