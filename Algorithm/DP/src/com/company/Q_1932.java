package com.company;

import java.util.Scanner;

public class Q_1932 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = -1;
        int[][] map = new int[n+1][n+1];

        for (int i = 1; i <= n; i++){
            for (int j =1; j <= i; j++){
                map[i][j] = scanner.nextInt();
                if (j == 1) map[i][j] = map[i-1][j] + map[i][j];
                else if (j == i) map[i][j] = map[i-1][j-1] + map[i][j];
                else map[i][j] = Math.max(map[i-1][j-1], map[i-1][j]) + map[i][j];

                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max);
        scanner.close();
    }
}
