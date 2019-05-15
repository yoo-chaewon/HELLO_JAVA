package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q_1012 {
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t_case = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < t_case; i++) {
            String[] data = bufferedReader.readLine().split(" ");
            int M = Integer.parseInt(data[0]);//가로
            int N = Integer.parseInt(data[1]);//세로
            int K = Integer.parseInt(data[2]);//배추 수
            int[][] map = new int[N][M];

            for (int j = 0; j < K; j++) {
                String[] data2 = bufferedReader.readLine().split(" ");
                int x = Integer.parseInt(data2[0]);
                int y = Integer.parseInt(data2[1]);
                map[y][x] = 1;
            }
            result.add(BFS(M, N, map));
        }
        for (int a : result){
            System.out.println(a);
        }
    }

    public static int BFS(int M, int N, int[][] map) {
        Queue<cabbageDOT> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    queue.add(new cabbageDOT(j, i));
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            cabbageDOT point = queue.poll();
            if (map[point.y][point.x] == 1) {
                map[point.y][point.x] = 2;
                count++;
            }
            if (queue.isEmpty()) {
                return count;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N || map[nextY][nextX] == 0 || map[nextY][nextX] == 2) {
                    continue;
                }
                map[nextY][nextX] = 2;
                ((LinkedList<cabbageDOT>) queue).addFirst(new cabbageDOT(nextX, nextY));
            }
        }
        return -1;
    }
}

class cabbageDOT {
    int x;
    int y;
    cabbageDOT(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
