package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//안전영역
public class Q_2468 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[num][num];

        int max = 0;
        for (int i = 0; i < num; i++) {
            String[] data = bufferedReader.readLine().split(" ");
            for (int j = 0; j < num; j++) {
                int tmp_data = Integer.parseInt(data[j]);
                map[i][j] = tmp_data;
                if (tmp_data > max) {
                    max = tmp_data;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= max; i++) {///
            Queue<safe_Dot> queue = new LinkedList<>();
            int[][] visited = new int[num][num];
            int count = 0;
            for (int j = 0; j < num; j++) {
                for (int k = 0; k < num; k++) {
                    if (map[j][k] > i) {//안전지역
                        queue.add(new safe_Dot(k, j));
                    }
                }
            }
            while (!queue.isEmpty()) {
                safe_Dot dot = queue.poll();
                if (visited[dot.py][dot.px] == 0) {
                    count++;
                    visited[dot.py][dot.px] = 1;
                }
                if (queue.isEmpty()) {
                    result.add(count);
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    int nextX = dot.px + dx[j];
                    int nextY = dot.py + dy[j];
                    if (nextX < 0 || nextY < 0 || nextX >= num || nextY >= num || map[nextY][nextX] <= i || visited[nextY][nextX] != 0) {
                        continue;
                    }
                    visited[nextY][nextX] = 1;
                    ((LinkedList<safe_Dot>) queue).addFirst(new safe_Dot(nextX, nextY));
                }
            }
        }

        Collections.sort(result);
        Collections.reverse(result);
        System.out.println(result.get(0));

    }
}

class safe_Dot {
    int px;
    int py;

    safe_Dot(int px, int py) {
        this.px = px;
        this.py = py;
    }
}
