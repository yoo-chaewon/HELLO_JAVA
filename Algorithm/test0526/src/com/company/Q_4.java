package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_4 {
    static int size_h;
    static int size_v;
    static int[][] map;
    static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = bufferedReader.readLine().split(" ");
        size_h = Integer.parseInt(size[0]);
        size_v =Integer.parseInt(size[1]);
        map = new int[size_v + 1][size_h + 1];
        min = Math.min(size_h, size_v);

        for (int i = 0; i < size_v; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < size_h; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        while (true){
            int temp = 0;
            for (int i = 0; i < size_v; i++){
                for (int j = 0; j < size_h; j++){
                    if (check(j, i) == false){//false
                        temp = 100;
                    }
                    if (check(j,i ) == true){
                        System.out.println(min * min);
                        return;
                    }
                }
            }
            if (temp == 100){
                min--;
                continue;
            }
        }


    }
    public static boolean check(int x, int y){
        if (y+min-1 >= size_v || x+min-1>= size_h){
            return false;
        }
        for (int i = y; i < y+min-1; i++){
            for (int j = x; j < x+min-1; j++){
                if(map[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
