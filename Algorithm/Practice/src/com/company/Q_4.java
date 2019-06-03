package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++){
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < size; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        System.out.println(Solution4.solution(size, map));
    }
}
class Solution4 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Dot> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (computers[i][j] == 1) {
                    queue.offer(new Dot(j, i));
                }
            }
        }
        while (!queue.isEmpty()){
            Dot current = ((LinkedList<Dot>) queue).pollFirst();
            if (computers[current.y][current.x] == 1){
                computers[current.y][current.x] = 2;
                answer++;
            }
            for (int i = 0; i < 4; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= n || nextY >= n || nextX <0 || nextY <0 || computers[nextY][nextX] != 1) continue;
                computers[nextY][nextX] = 2;
                ((LinkedList<Dot>) queue).addFirst(new Dot(nextX, nextY));
            }
        }
        return answer;
    }
}
class Dot{
    int x;
    int y;
    Dot(int x, int y ){
        this.x = x;
        this.y = y;
    }
}
/**
 * 3
 * 1 1 0
 * 1 1 0
 * 0 0 1
 *
 * 3
 * 1 1 0
 * 1 1 1
 * 0 1 1
 *
 * */