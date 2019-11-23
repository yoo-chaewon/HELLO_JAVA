package com.company;

import javax.sound.midi.Soundbank;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BFSDFS02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                map[i][j] = scanner.nextInt();
            }
        }
        int[][] result = Solution02.solution(size, map);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println(result[i][j]);
            }
            System.out.println();
        }
    }
}

class Solution02 {
    static int[][] result;
    public static int[][] solution(int size, int[][] map) {
        result = map;
        boolean[] visited = new boolean[size];
        Arrays.fill(visited, false);

        for (int i = 0; i < size; i++){
            DFS(i, visited, result);
        }

        return result;
    }

    public static void DFS(int index, boolean[] visited, int[][] map){
        visited[index] = true;

        for (int i = 0; i < visited.length; i++){
            if (visited[i] == false && map[index][i] == 1){
                map[i]
                DFS(i, visited, map);
            }
        }
    }
}
