package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2178_DFS {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];

        for (int i = 0; i < N; i++) {
            String[] data = bufferedReader.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(data[j]);
            }
        }
        DFS(0, 0, 1);
        System.out.println(min);
    }
    static int min = 9999;
    public static void DFS(int x, int y, int count) {
        if (x == M - 1 && y == N - 1) {
            if (min > count) {
                min = count;
                return;
            }
        }
        map[y][x] = 0;
        if(x > 0 && map[y][x-1] == 1) {//left
            DFS(x-1, y, count+1);
        }
        if(x < M && map[y][x+1] == 1) {//right
            DFS(x+1, y, count+1);
        }
        if(y < M && map[y+1][x] == 1) {//down
            DFS(x, y+1, count+1);
        }
        if(y > 0 && map[y-1][x] == 1) {//up
            DFS(x, y-1, count+1);
        }
        map[y][x] = 1;
    }
}
