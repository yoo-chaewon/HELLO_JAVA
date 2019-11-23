package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q_1865 {
    static ArrayList<Dot>[] arrayLists;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bufferedReader.readLine());

        for (int k = 0; k < test_case; k++){
            String[] NMW = bufferedReader.readLine().split(" ");
            N = Integer.parseInt(NMW[0]);//지점
            int M = Integer.parseInt(NMW[1]);//도로
            int W = Integer.parseInt(NMW[2]);//웜홀
            arrayLists = new ArrayList[N+1];

            for (int a = 1; a < N+1; a++){
                arrayLists[a] = new ArrayList<>();
            }
            for (int b = 0; b < M; b++){
                String[] data = bufferedReader.readLine().split(" ");
                int node1 = Integer.parseInt(data[0]);
                int node2 = Integer.parseInt(data[1]);
                int cost = Integer.parseInt(data[2]);
                arrayLists[node1].add(new Dot(node2, cost));
                arrayLists[node2].add(new Dot(node1, cost));
            }
            for (int c = 0; c < W; c++){
                String[] w_data = bufferedReader.readLine().split(" ");
                int w_start = Integer.parseInt(w_data[0]);
                int w_dest = Integer.parseInt(w_data[1]);
                int w_cost = Integer.parseInt(w_data[2]);
                arrayLists[w_start].add(new Dot(w_dest, w_cost*-1));
            }
            boolean check = false;
            int[] distance = new int[N+1];

            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[1] = 0;//1이 시작점
            for (int i = 1; i <= N; i++){//N-1번 하는데, N번째 바뀌면 순환 있는 것.
                for (int j = 1; j <= N; j++){//노드 1-N 순서대로 보기
                    for (Dot next: arrayLists[j]){
                        if (distance[j] == Integer.MAX_VALUE) continue;
                        if (distance[next.dest] > distance[j] + next.cost){
                            distance[next.dest] = distance[j] + next.cost;
                            if (i == N) check = true;
                        }
                    }
                }
            }
            System.out.println(check? "YES": "NO");
        }
    }
}
class Dot{
    int dest;
    int cost;
    Dot(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
}