package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Q_2468 {
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int size;
    static int[][] temp_map;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());
        map = new int[size][size];

        int max = 0;
        for (int i = 0; i < size; i++) {
            String[] data = bufferedReader.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                int temp_data = Integer.parseInt(data[j]);
                map[i][j] = temp_data;
                if (temp_data > max) {
                    max = temp_data;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            temp_map = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    temp_map[j][k] = map[j][k];
                }
            }
            int count = 0;
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (temp_map[j][k] > i && temp_map[j][k] != 200) {
                        count++;
                        safe_DFS(i, k, j);
                    }
                }
            }
            result.add(count);
        }
        Collections.sort(result);
        Collections.reverse(result);
        System.out.println(result.get(0));
    }
    static void safe_DFS(int bound, int x, int y) {
        temp_map[y][x] = 200;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size || map[nextY][nextX] <= bound) {
                continue;
            }
            if (temp_map[nextY][nextX] > bound && temp_map[nextY][nextX] != 200) {
                safe_DFS(bound, nextX, nextY);
            }
        }
    }
}

