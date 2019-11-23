package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_1003_DP {
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bufferedReader.readLine());
        while (test_case -- > 0){
            int num = Integer.parseInt(bufferedReader.readLine());
            map = new int[num+2][2];

            map[0][0] = 1;
            map[1][1] = 1;

            for (int i = 2; i < num+1; i++){
                for (int j = 0; j < 2; j++){
                    map[i][j] = map[i-1][j] + map[i-2][j];
                }
            }

            System.out.println(map[num][0] + " " + map[num][1]);
        }
    }
}
