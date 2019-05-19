package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_1753 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] VE = bufferedReader.readLine().split(" ");

        int V = Integer.parseInt(VE[0]);//정점수
        int E = Integer.parseInt(VE[1]);//간선수
        int[][] map = new int[V + 1][V + 1];

        int start = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < E; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            map[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = Integer.parseInt(input[2]);
        }

        int[] distance = new int[V+1];
        boolean[] check = new boolean[V+1];

        for (int i = 0; i < V+1; i++){
            distance[i] = 99;
        }

        distance[start] = 0;
        check[start] = true;

        for (int i = 1; i <= V; i++){
            if (!check[i] && map[start][i] != 0){
                distance[i] = map[start][i];
            }
        }

        for (int a = 2; a < V; a++){
            int min = 99;
            int min_index = -1;

            for (int i = 1; i <= V; i++){
                if (check[i]==false && distance[i]!= 99){
                    if (distance[i] < min){
                        min = distance[i];
                        min_index = i;
                    }
                }
            }
            check[min_index] = true;
            for (int i = 1; i < V+1; i++){
                if (check[i]==false && map[min_index][i] != 0){
                    if (distance[i] > distance[min_index] + map[min_index][i]){
                        distance[i] = distance[min_index] + map[min_index][i];
                    }
                }
            }
        }

        for (int i = 1; i < V+1; i++){
            if (distance[i] == 99){
                System.out.println("INF");
            }else {
                System.out.println(distance[i]);
            }
        }
    }
}
