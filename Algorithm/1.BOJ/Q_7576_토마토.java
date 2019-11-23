package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//BFS
public class Q_7576 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++){
            String[] data = bufferedReader.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(data[j]);
            }
        }
        BFS(map, N, M);
    }

    static public void BFS(int[][] map, int N, int M){
        Queue<Dot> queue = new LinkedList<Dot>();
        for (int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if (map[i][j] == 1){
                    queue.add(new Dot(i,j));
                }
            }
        }
        while (queue.isEmpty() == false){
            Dot dot = queue.poll();
            for (int i = 0; i < 4; i++){
                int nextX = dot.x + dx[i];
                int nextY = dot.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M){
                    continue;
                }
                if (map[nextX][nextY] != 0){
                    continue;
                }
                map[nextX][nextY] = map[dot.x][dot.y]+1;
                queue.add(new Dot(nextX, nextY));
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max-1);
    }
}
class Dot{
    int x;
    int y;
    Dot(int x, int y){
        this.x = x;
        this.y = y;
    }
}

