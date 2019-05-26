package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        int input_num = Integer.parseInt(input);
        int len = input.length();

        int sum = 0;
        for (int i = 0; i < len ; i ++){
            sum += input_num % 10;
            input_num = input_num/10;
        }
        System.out.println(sum);
    }
}
