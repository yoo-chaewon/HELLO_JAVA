package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_7569 {
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dh = {0,0,0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bufferedReader.readLine());
        int M = Integer.parseInt(st.nextToken());//가로
        int N = Integer.parseInt(st.nextToken());//세로
        int H = Integer.parseInt(st.nextToken());//높이
        int[][][] map = new int[H + 1][N + 1][M + 1];
        Queue<Point> queue = new LinkedList<Point>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(bufferedReader.readLine());
                for (int k = 0; k < M; k++) {
                    int data = Integer.parseInt(st.nextToken());
                    map[i][j][k] = data;
                    if (data == 1){
                        queue.add(new Point(k, j, i));
                    }
                }
            }
        }

        while (queue.isEmpty() == false){
            Point point = queue.poll();
            for (int i = 0; i < 6; i++){
                int nextX = point.px + dx[i];
                int nextY = point.py + dy[i];
                int nextH = point.ph + dh[i];

                if (nextX<0|| nextY<0 || nextH<0 || nextX >= M|| nextY >= N || nextH >= H){
                    continue;
                }
                if (map[nextH][nextY][nextX] != 0){
                    continue;
                }
                map[nextH][nextY][nextX] = map[point.ph][point.py][point.px] + 1;
                queue.add(new Point(nextX, nextY, nextH));

            }
        }
        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, map[i][j][k]);
                }
            }
        }
        System.out.println(max-1);
    }
}

class Point {
    int px;
    int py;
    int ph;
    Point(int px, int py, int ph){
        this.px = px;
        this.py = py;
        this.ph = ph;
    }
}

