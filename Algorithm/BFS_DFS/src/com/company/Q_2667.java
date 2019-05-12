package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q_2667 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[len + 1][len + 1];
        int[][] visited = new int[len + 1][len + 1];
        Queue<APT_point> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            String[] data = bufferedReader.readLine().split("");
            for (int j = 0; j < len; j++) {
                map[i][j] = Integer.parseInt(data[j]);
                if (map[i][j] == 1) {
                    queue.add(new APT_point(j, i));
                }
            }
        }
        int apt = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        while (queue.isEmpty() == false) {
            APT_point point = queue.poll();

            if (queue.isEmpty() == true){
                result.add(count);
            }
            if (visited[point.py][point.px] == 0){
                apt++;
                if (apt != 1) {
                    result.add(count);
                }
                count = 1;
            }
            visited[point.py][point.px] = 1;
            for (int i = 0; i < 4; i++) {
                int nextX = point.px + dx[i];
                int nextY = point.py + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= len || nextY >= len) {
                    continue;
                }
                if (map[nextY][nextX] == 1 && visited[nextY][nextX] == 0) {
                    visited[nextY][nextX] = 1;
                    ((LinkedList<APT_point>) queue).addFirst(new APT_point(nextX, nextY));
                    count++;
                }
            }
        }
        System.out.println(apt);
        Collections.sort(result);
        for (int a : result) {
            System.out.println(a);
        }
    }
}

class APT_point {
    int px;
    int py;
    APT_point(int px, int py) {
        this.px = px;
        this.py = py;
    }
}
