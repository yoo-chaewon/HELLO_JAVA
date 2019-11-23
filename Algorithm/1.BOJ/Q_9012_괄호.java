import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class VPS {
    public static void main(String[] args){
        try{
            VPSMain();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //9012
    public static void VPSMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < num; i++) {
            String input = bufferedReader.readLine();
            VPS(input);
        }

    }
    public static void VPS(String input) {
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
}
