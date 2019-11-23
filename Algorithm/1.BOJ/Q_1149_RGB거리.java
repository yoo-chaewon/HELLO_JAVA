package com.company;

import java.util.Scanner;
//RGB
public class Q_1149 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int[][] map = new int[H+1][5];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < H+1; i++){
            for (int j = 0; j < 3; j++){
                int input = scanner.nextInt();
                if (j == 0) map[i][j] = Math.min(map[i-1][1], map[i-1][2]) + input;
                if (j == 1) map[i][j] = Math.min(map[i-1][0], map[i-1][2]) + input;
                if (j == 2) map[i][j] = Math.min(map[i-1][0], map[i-1][1]) + input;
                if (i == H) min = Math.min(min, map[i][j]);
            }
        }
        System.out.println(min);
    }
}
