package com.company;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int xSize;
    static int ySize;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int testCase = scanner.nextInt();
        for (int k = 0; k < testCase; k++){
            xSize = scanner.nextInt();
            ySize = scanner. nextInt();

            int[][] map = new int[ySize][xSize];
            int K = scanner.nextInt();
            for (int i = 0; i < K; i++){
                int pointX = scanner.nextInt();
                int pointY = scanner.nextInt();
                map[pointY][pointX] = 1;
            }

            int count = 0;
            for (int i = 0; i < ySize; i++){
                for (int j = 0; j < xSize; j++){
                    if (map[i][j] == 1){
                        count++;
                        DFS(map, j, i);
                    }
                }
            }
            System.out.println(count);

        }
    }

    public static void DFS(int[][] map, int x, int y){
        int[] dx = {-1, 1, 0,0 };
        int[] dy = {0, 0, -1, 1};

        map[y][x] = 2;
        for (int i = 0; i < 4; i++){
            int curX = x + dx[i];
            int curY = y + dy[i];
            if (curX >= xSize || curY >= ySize || curX < 0 || curY < 0 || map[curY][curX] == 0 || map[curY][curX] == 2){
                continue;
            }
            DFS(map, curX, curY );
        }
    }
}


