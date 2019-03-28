import java.awt.print.Book;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main obj = new Main();
/*
        try {
            //obj.Zmain();
            obj.BookMain();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //obj.pillMain();
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
        if (pill[w][h] > 0) {
            return pill[w][h];
        }
        if (w > 0 || h > 0) {
            pill[w][h] = pill(pill, w - 1, h + 1) + pill(pill, w, h - 1);
        }
        return pill[w][h];
    }

    static int n, r, c;
    static int result = 0;

    //1074
    public void Zmain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        Z((int) Math.pow(2, n), 0, 0);
    }
    public void Z(int len, int row, int col) {
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

    //1914
    public void HanoiMain() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        try {
            num = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BigInteger bi = new BigInteger("2");
        //2의 n제곱 -1
        BigInteger c = bi.pow(num).subtract(BigInteger.ONE);
        System.out.println(c);
        if(num <= 20) {
            Hanoi(num, 1, 2, 3);
        }
    }

    public void Hanoi(int num, int start, int mid, int end) {

        if (num == 1) {
            System.out.println(start + " " + end);
        } else {
            Hanoi(num - 1, start, end, mid);
            System.out.println(start + " " + end);
            Hanoi(num - 1, mid, start, end);
        }
    }

    //1019
    public void BookMain() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] arr = new int[10];

        for (int i : Book(N, arr)) {
            System.out.print(i + " ");
        }
    }

    public int[] Book(int N, int[] arr) {
        if (N <= 0) {
            return arr;
        }
        if (N < 10) {
            arr[N] += 1;
            Book(N - 1, arr);
            return arr;
        } else {
            if (N % 10 == 0) {
                arr[0] += 1;
                Book(N / 10, arr);
                Book(N - 1, arr);
            } else {
                Book(N / 10, arr);
                Book(N % 10, arr);
                Book(N - 1, arr);
            }
        }
        return arr;
    }
}

