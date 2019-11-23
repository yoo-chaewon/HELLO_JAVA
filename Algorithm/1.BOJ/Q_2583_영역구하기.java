package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q_2583 {
    static int M;
    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] data = bufferedReader.readLine().split(" ");
        M = Integer.parseInt(data[0]);//세로
        N = Integer.parseInt(data[1]);//가로
        int k = Integer.parseInt(data[2]);//줄
        map = new int[M][N];

        for (int i = 0; i < k; i++) {
            String[] points = bufferedReader.readLine().split(" ");
            int x1 = Integer.parseInt(points[0]);
            int y1 = Integer.parseInt(points[1]);
            int x2 = Integer.parseInt(points[2]);
            int y2 = Integer.parseInt(points[3]);
            for (int j = y1; j < y2; j++) {
                for (int z = x1; z < x2; z++) {
                    map[j][z] = 1;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    count = 0;
                    DFS(j, i);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int a : result){
            System.out.print(a + " ");
        }
    }

    public static void DFS(int x, int y) {
        map[y][x] = 1;
        count++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }
            if (map[nextY][nextX] == 0) {
                DFS(nextX, nextY);
            }
        }
    }
}
