package com.company;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] picture = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                picture[i][j] = scanner.nextInt();
            }
        }
        for (int a : Solution05.solution(m, n, picture)) {
            System.out.print(a);
        }
    }
}

class Solution05 {
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int curArea = 1;
        int[] answer = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[j][i] != 0) {
                    curArea = DFS(m, n, j, i, picture[i][j], picture);
                    maxSizeOfOneArea = Math.max(curArea, maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int DFS(int m, int n, int x, int y, int prev, int[][] picture) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

//        if (picture[curY][curX] != prev) return 0;
//        picture[x][y] = 0;
//
//        for (int i = 0; i < 4; i++) {
//            int curX = x + dx[i];
//            int curY = y + dy[i];
//
//            if (curX < 0 || curX >= n || curY < 0 || curY >= m ||  picture[curY][curX] == 0) continue;
//
//            if (picture[curY][curX] != prev) continue;
//
//            temp_count += dfs(nx, ny, m, n,prev);
//        }
//        return temp_count;
        return 0;

    }
}
/*
6 4
1 1 1 0
1 2 2 0
1 0 0 1
0 0 0 1
0 0 0 3
0 0 0 3
* */