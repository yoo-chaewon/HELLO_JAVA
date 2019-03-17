import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Main obj = new Main();
        obj.pillMain();
        /*
        try {
            obj.Zmain();
        }catch (IOException e){
            e.printStackTrace();
        }*/
    }

    //4811
    public void pillMain() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Long> result = new ArrayList<Long>();
        while (true) {
            try {
                int input = Integer.parseInt(br.readLine());
                if (input == 0) {
                    break;
                } else {
                    long[][] arr = new long[input + 1][input + 1];
                    result.add(pill(arr, input, 0));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (long r : result) {
            System.out.println(r);
        }
    }

    public long pill(long[][] pill, int w, int h) {
        if ((w == 1 && h == 0) || (w == 0 && h == 1)) {
            return 1;
        } else if (w < 0 || h < 0) {
            return 0;
        }
        if (pill[w][h] > 0){
            return pill[w][h];
        }
        if (w > 0|| h > 0) {
            pill[w][h] = pill(pill, w - 1, h + 1) + pill(pill, w, h - 1);
        }
        return pill[w][h];
    }

    //1074
    public void Zmain() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int row = Integer.parseInt(input[1]);
        int col = Integer.parseInt(input[2]);

        Z(n, row, col);
    }
    public void Z(int n, int row, int col){
        int result;
        //Z();


        //System.out.println(result);
    }
}

