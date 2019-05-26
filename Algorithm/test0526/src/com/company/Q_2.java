package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int size = input.length;
        int max = 0;
        for (int i = 0; i < size; i++){
            max = Math.max(max, Integer.parseInt(input[i]));
        }
        int[] arr = new int[max+1];

        for (int i = 0; i < size; i++){
            arr[Integer.parseInt(input[i])]++;
        }

        for (int i = 1; i < size+1; i++){
            if (arr[i] == 0 || arr[i] > 1){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
