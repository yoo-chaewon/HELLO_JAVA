package com.company;

import sun.tools.tree.ArrayAccessExpression;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Greedy05 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[][] routes = new int[size][2];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < 2; j++){
                routes[i][j] = scanner.nextInt();
            }
        }
        System.out.println(Solution05.solution(routes));
    }
}

class Solution05 {
    public static int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer route1 = o1[0];
                Integer route2 = o2[0];
                return route1.compareTo(route2);
            }
        });

        int start = routes[0][0];
        int end = routes[0][1];
        for (int i = 1; i < routes.length; i++){
            if (!(start <= routes[i][0] && routes[i][0] <= end)){
                answer++;
                start = routes[i][0];
                end = routes[i][1];
            }else{
                start = Math.max(start, routes[i][0]);
                end = Math.min(end, routes[i][1]);
            }
        }
        return answer;
    }
}