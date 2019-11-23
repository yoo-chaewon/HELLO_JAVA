import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Hanoi {
    public static void main(String[] args){
        HanoiMain();
    }
    //1914
    public static void HanoiMain() {
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
    public static void Hanoi(int num, int start, int mid, int end) {
        if (num == 1) {
            System.out.println(start + " " + end);
        } else {
            Hanoi(num - 1, start, end, mid);
            System.out.println(start + " " + end);
            Hanoi(num - 1, mid, start, end);
        }
    }
}
