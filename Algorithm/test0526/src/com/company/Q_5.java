package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_5 {
    static int N;
    static int M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());//세로
        M = 4; //가로
        map = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            min = Math.min(min, DFS(i, 0));
        }
        System.out.println(min);
    }

    public static int DFS(int x, int y) {
        if (x >= M || y >= N){
            return map[y][x];
        }
        for (int i = 0; i < M; i++){
            if (i == x){
                continue;
            }
            DFS(i, y+1);
        }


        return -1;
    }
}
