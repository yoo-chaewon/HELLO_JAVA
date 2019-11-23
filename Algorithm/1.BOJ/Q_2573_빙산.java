package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q_2573 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int H,B;
    static int[][] map;
    static int year = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] HB = bufferedReader.readLine().split(" ");
        H = Integer.parseInt(HB[0]);//세로
        B = Integer.parseInt(HB[1]);//가로
        map = new int[H][B];

        for (int i = 0; i < H; i ++){
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < B; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        while (true) {
            int[][] temp_map = new int[H][B];
            Queue<IcePoint> queue = new LinkedList<>();
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < B; j++) {
                    temp_map[i][j] = map[i][j];
                    if (map[i][j] > 0) {
                        queue.add(new IcePoint(j, i));
                    }
                }
            }
            while (!queue.isEmpty()){
                IcePoint point = queue.poll();
                for (int i = 0; i < 4; i++){
                    int nextX = point.x + dx[i];
                    int nextY = point.y + dy[i];

                    if (nextX < 0 || nextY < 0|| nextX >= B || nextY >= H || map[nextY][nextX] != 0){
                        continue;
                    }
                    if (map[nextY][nextX] == 0){
                        temp_map[point.y][point.x]--;
                        map[point.y][point.x]--;
                    }
                }
            }
            year++;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < B; j++){
                    if (map[i][j] != 0){
                        queue.add(new IcePoint(j, i));
                    }
                }
            }
            int count = 0;
            while (!queue.isEmpty()){
                IcePoint point = queue.poll();
                if (temp_map[point.y][point.x] != -1){
                    temp_map[point.y][point.x] = -1;
                    count++;
                }
                for (int i = 0; i < 4; i++){
                    int nextX = point.x + dx[i];
                    int nextY = point.y + dy[i];

                    if (nextX < 0 || nextY < 0|| nextX >= B || nextY >= H || map[nextY][nextX] == 0 ){
                        continue;
                    }
                    temp_map[nextY][nextX] = -1;
                }
            }
            if (count >= 2){
                System.out.println(year);
                return;
            }
        }
    }

}
class IcePoint{
    int x;
    int y;
    IcePoint(int x, int y ){
        this.x = x;
        this.y = y;
    }
}
