package com.company;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BFSDFS01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[][] computers = new int[size][size];
        for (int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                computers[i][j] = scanner.nextInt();
            }
        }
        System.out.println(Solution01.solution(size, computers));
    }
}
class Solution01 {
    static boolean[] visited;
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++){
            if(visited[i] == false){
                DFS(i, computers);
                answer++;
            }

        }

        return answer;
    }

    public static void DFS(int index, int[][] computers){
        visited[index] = true;

        for (int i = 0; i < computers.length; i++){
            if (visited[i] == false && computers[index][i] == 1) DFS(i, computers);
        }
    }
}