package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_1753 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] VE = bufferedReader.readLine().split(" ");
        int V = Integer.parseInt(VE[0]);//정점 수
        int E = Integer.parseInt(VE[1]);//간선 수
        int[][] map = new int[V + 1][V + 1];

        int start = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < E; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            map[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = Integer.parseInt(input[2]);
        }
        boolean[] visited = new boolean[V + 1];
        int[] distance = new int[V + 1];

        for (int i = 1; i < V + 1; i++) {
            distance[i] = 99;
        }
        visited[start] = true;
        distance[start] = 0;

        for (int i = 1; i < V + 1; i++) {
            if (visited[i] == false && map[start][i] != 0) {
                distance[i] = map[start][i];
            }
        }

        while (true){
            int min = 99;
            int min_index = -1;
            for (int i = 1; i < V + 1; i++) {
                if (distance[i] < min && visited[i] == false) {
                    min = distance[i];
                    min_index = i;
                }
            }
            if (min_index == -1){
                for (int i = 1; i < V+1; i++){
                    if (distance[i] == 99){
                        System.out.println("INF");
                    }else {
                        System.out.println(distance[i]);
                    }
                }
                return;
            }
            visited[min_index] = true;

            for (int j = 1; j < V + 1; j++) {
                if (map[min_index][j] != 0 && visited[j] == false) {
                    if (distance[j] > distance[min_index] + map[min_index][j]) {
                        distance[j] = distance[min_index] + map[min_index][j];
                    }
                }
            }
        }
    }
}