import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Main obj = new Main();
        //obj.pillMain();
        /*
        try {
            obj.Zmain();
        }catch (IOException e){
            e.printStackTrace();
        }*/
        //obj.BookMain();
        obj.HanoiMain();
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

        Z((int)Math.pow(2,n), row, col);
    }
    public void Z(int n, int row, int col){

    }

    //1914
    public void HanoiMain(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        try {
            num = Integer.parseInt(bufferedReader.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println((int)Math.pow(2,num)-1);
        Hanoi(num, 1, 2, 3);
    }
    static int count = 0;
    public void Hanoi(int num, int start, int mid, int end){

        if (num == 1){
            System.out.println(start + " " + end);
        }else {
            Hanoi(num-1, start, end, mid);
            System.out.println(start + " " + end);
            Hanoi(num-1, mid, start, end);
        }
    }
}

