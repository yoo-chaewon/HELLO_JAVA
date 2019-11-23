package com.company;

import java.util.Scanner;

public class Q_9095 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int test_case = scanner.nextInt();
        int[] map = new int[12];
        map[1] = 1;
        map[2] = 2;
        map[3] = 4;
        for (int i = 4; i < 12; i++){
            map[i] = map[i-1] + map[i-2] + map[i-3];
        }

        while (test_case-- >0){
            int input = scanner.nextInt();
            System.out.println(map[input]);
        }
    }
}
