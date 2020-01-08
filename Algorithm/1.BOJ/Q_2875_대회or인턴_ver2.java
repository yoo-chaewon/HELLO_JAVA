package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_1003 {
    static int[] arr;
    static int num0 = 0;
    static int num1 = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bufferedReader.readLine());
        while (test_case-- > 0){
            int num = Integer.parseInt(bufferedReader.readLine());
            arr = new int[num+1];
            fibonacci(num);
            System.out.println(num0 + " " + num1);
            num0 = 0; num1 = 0;
        }
    }
    public static int fibonacci(int x){
        if (x == 0) {
            num0++;
            return 0;
        }
        if (x == 1) {
            num1++;
            return  1;
        }
        else return fibonacci(x-1) + fibonacci(x-2);
    }
}
