import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());

        while (t-- > 0) {
            int size = Integer.parseInt(bufferedReader.readLine());
            String[] arr = new String[size];
            for (int i = 0; i < size; i++){
                arr[i] = bufferedReader.readLine();
            }
            Arrays.sort(arr);

            if (CheckContain(arr, size)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static boolean CheckContain(String[] arr, int size){
        for (int i = 0; i < size-1; i++){
            String cur = arr[i];
            String next = arr[i+1];
            if (cur.startsWith(next) || next.startsWith(cur)) return false;
        }
        return true;
    }
}