package com.company;

import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Heap03 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[][] jobs = new int[size][2];
        for (int i = 0; i < size; i ++){
            jobs[i][0] = scanner.nextInt();
            jobs[i][1] = scanner.nextInt();
        }
        System.out.println(Solution03.solution(jobs));
    }
}

class Solution03 {
    public static int solution(int[][] jobs) {
        int answer = 0;
        int cur = 0;

        for (int i = 0; i < jobs.length; i++){
            answer = cur + jobs[i][1] - jobs[i][0];
            cur += jobs[i][1];


        }

        return answer/jobs.length;
    }
}
