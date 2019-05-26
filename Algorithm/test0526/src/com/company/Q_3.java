package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Dot> arrayList = new ArrayList<>();
        int xmax = 0;
        int ymax = 0;
        for (int i = 0; i < 3; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int input1 = Integer.parseInt(input[0]);
            xmax = Math.max(xmax, input1);
            int input2 = Integer.parseInt(input[1]);
            ymax = Math.max(ymax, input2);
            arrayList.add(new Dot(input1, input2));
        }
        int[] x_arr = new int[xmax+1];
        int[] y_arr = new int[ymax+1];

        for (int i = 0; i < arrayList.size(); i++){
            x_arr[arrayList.get(i).x] ++;
            y_arr[arrayList.get(i).y] ++;
        }

        int x = 0;
        int y = 0;
        for (int i = 1; i < xmax +1; i++){
            if (x_arr[i] == 1){
                x = i;
            }
        }
        for (int i = 1; i < ymax +1; i++){
            if (y_arr[i] == 1){
                y = i;
            }
        }
        System.out.println(x + "," + y);
    }
}
class Dot {
    int x;
    int y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
