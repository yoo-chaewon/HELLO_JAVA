package com.company;

import java.util.Scanner;
//계단 오르기
public class Q_2579 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] map = new int[num+1];
        int[] sum = new int[num+1];
        for (int i = 0; i < num; i++){
            map[i] = scanner.nextInt();
        }
        sum[0] = map[0];
        sum[1] = Math.max(map[1], map[1]+ map[0]);
        sum[2] = Math.max(map[0] + map[2], map[1] + map[2]);

        for (int i = 3; i < num; i++){
            sum[i] = Math.max(map[i-1] + sum[i-3] , sum[i-2]) + map[i];
        }
        System.out.println(sum[num-1]);

    }

}
