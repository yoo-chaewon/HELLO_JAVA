import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Z {
    public static void main(String[] args){
        try{
            Zmain();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    static int n, r, c;
    static int result = 0;

    //1074
    public static void Zmain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        Z((int) Math.pow(2, n), 0, 0);
    }
    public static void Z(int len, int row, int col) {
        if (r == row && c == col){
            System.out.println(result);
            return;
        }
        if (len == 1){
            result++;
            return;
        }

        Z(len/2, row, col);
        Z(len/2, row, col+len/2);
        Z(len/2, row+len/2, col);
        Z(len/2, row+len/2, col+len/2);
    }
}
