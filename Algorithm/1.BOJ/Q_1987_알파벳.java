package com.company;

import sun.awt.geom.AreaOp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q_1987 {
    static String[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Integer> result;
    static int R;
    static int C;
    static int count;
    static ArrayList<String > visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        R = Integer.parseInt(input[0]);//세로
        C = Integer.parseInt(input[1]);//가로

        map = new String[R][C];
        for (int i = 0; i < R; i++) {
            String[] data = bufferedReader.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = data[j];
            }
        }
        visited = new ArrayList<>();
        result = new ArrayList<>();
        Alpha_DFS(0, 0);
        Collections.sort(result);
        Collections.reverse(result);
        if (result.size() > 0) {
            System.out.println(result.get(0));
        }
    }

    public static void Alpha_DFS(int x, int y) {
        visited.add(map[y][x]);
        count++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= C || nextY >= R || visited.contains(map[nextY][nextX])) {
                result.add(count);
                continue;
            }
            Alpha_DFS(nextX, nextY);
        }
    }
}
