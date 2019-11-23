package com.company;

import java.io.InputStreamReader;
import java.util.Scanner;

public class BP02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[][] baseball = new int[size][3];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < 3; j++){
                baseball[i][j] = scanner.nextInt();
            }
        }
        System.out.println(Solution02.solution(baseball));
    }
}
class Solution02 {
    public static int solution(int[][] baseball) {
        int answer = 0;



        return answer;
    }
}