package com.company;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Programmers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] picture = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                picture[i][j] = scanner.nextInt();
            }
        }
        for (int a : Solution.solution(m, n , picture)){
            System.out.println(a);
        }
    }
}

class Solution {
    static int xSize = 0;
    static int ySize = 0;
    static int area = 0;
    static boolean[][] visited;
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = Integer.MIN_VALUE;

        xSize = n;
        ySize = m;
        visited = new boolean[m][n];

        int[] answer = new int[2];

        for (int i = 0; i < ySize ;i++){
            for (int j = 0; j < xSize; j++){
                if (picture[i][j] != 0 && picture[i][j] != -1 && visited[i][j] == false){
                    visited[i][j] = true;
                    area = 0;
                    int curValue = picture[i][j];
                    numberOfArea++;
                    DFS(picture, j, i, curValue);//x, y
                    maxSizeOfOneArea = Math.max(area, maxSizeOfOneArea);
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void DFS(int[][] picture, int x, int y, int curValue){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        picture[y][x] = -1;
        area++;

        for (int i = 0; i < 4; i++){
            int curX = x + dx[i];
            int curY = y + dy[i];

            if (curX < xSize && curY < ySize && curX >= 0 && curY >= 0 && picture[curY][curX] == curValue && visited[curY][curX] == false){
                DFS(picture, curX, curY, curValue);
                visited[curY][curX] = true;
            }
        }
    }
}