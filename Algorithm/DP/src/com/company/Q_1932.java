package com.company;

import java.util.Scanner;

public class Q_1932 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] map = new int[num+1][num+1];
        int max = -1;
        for (int i = 1; i < num+1; i++){
            for (int j = 1; j < i+1; j++){
                int input = scanner.nextInt();
                if (j == 1) map[i][j] = map[i-1][j] + input;
                if (j == i) map[i][j] = map[i-1][j-1] + input;
                else map[i][j] = Math.max(map[i-1][j-1], map[i-1][j]) + input;

                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max);
        scanner.close();
    }
}
