package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Q_11399 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] map = new int[size];

        for (int i = 0; i< size; i++){
            map[i] = scanner.nextInt();
        }

        Arrays.sort(map);
        int sum = map[0];
        for(int i = 0; i < size-1; i++){
            map[i+1] += map[i];
            sum += map[i+1];
        }

        System.out.println(sum);
    }
}
