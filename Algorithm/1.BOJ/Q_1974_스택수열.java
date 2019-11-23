import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class SequenceStack {
    public static void main(String[] args){
        try{
            SequenceStackMain();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //1874
    public static void SequenceStackMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        SequenceStack(arr);
    }

    public static void SequenceStack(int[] arr) {
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
}
