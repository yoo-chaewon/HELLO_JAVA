package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_5 {
    static int M;
    static int N;
    static int[][] map;
    static int max = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            DFS(map[0][i], i, 0);
        }
        System.out.println(max);
    }

    public static void DFS(int sum, int x, int y) {
        if (y == N-1) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < M; i++) {
            if (x == i) {
                continue;
            }
            DFS(sum + map[y+1][i], i, y + 1);
        }
    }
}
/*
*
3 4
1 2 3 5
5 6 7 8
4 3 2 1
*
* */