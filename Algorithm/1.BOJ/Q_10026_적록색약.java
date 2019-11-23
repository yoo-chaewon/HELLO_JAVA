package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_10026 {
    static String[][] map1;
    static String[][] map2;
    static int size;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());
        map1 = new String[size][size];
        map2 = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = bufferedReader.readLine().split("");
            for (int j = 0; j < size; j++) {
                map1[i][j] = input[j];
                map2[i][j] = input[j];
            }
        }
        count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!map1[i][j].equals("A")) {
                    count++;
                    DFS1(j, i, map1[i][j]);
                }
            }
        }
        System.out.println(count);

        count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!map2[i][j].equals("A")) {
                    count++;
                    DFS2(j, i, map2[i][j]);
                }
            }
        }
        System.out.println(count);
    }

    public static void DFS1(int x, int y, String str){
        map1[y][x] = "A";
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size) {
                continue;
            }
            if (str.equals("R")) {
                if (map1[nextY][nextX].equals("R")) {
                    DFS1(nextX, nextY, str);
                }
            }
            if ( str.equals("G")) {
                if (map1[nextY][nextX].equals("G")) {
                    DFS1(nextX, nextY, str);
                }
            }

            if (str.equals("B")) {
                if (map1[nextY][nextX].equals("B")) {
                    DFS1(nextX, nextY, str);
                }
            }
        }
    }

    public static void DFS2(int x, int y, String str) {
        map2[y][x] = "A";
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size) {
                continue;
            }
            if (str.equals("R") || str.equals("G")) {
                if (map2[nextY][nextX].equals("R") || map2[nextY][nextX].equals("G")) {
                    DFS2(nextX, nextY, str);
                }
            }

            if (str.equals("B")) {
                if (map2[nextY][nextX].equals("B")) {
                    DFS2(nextX, nextY, str);
                }
            }
        }
    }
}
