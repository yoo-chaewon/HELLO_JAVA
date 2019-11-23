package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q_10217 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bufferedReader.readLine());
        for (int k = 0; k < test_case; k++) {
            String[] NMK = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(NMK[0]);//공항수
            int M = Integer.parseInt(NMK[1]);//지원비
            int K = Integer.parseInt(NMK[2]);//티켓정보수

            ArrayList<Destination>[] arrayList = new ArrayList[N + 1];
            for (int i = 1; i < N + 1; i++) {
                arrayList[i] = new ArrayList<>();
            }
            int fee = 0;
            for (int i = 0; i <K; i++){
                String[] input = bufferedReader.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int dest = Integer.parseInt(input[1]);
                fee = Integer.parseInt(input[2]);
                int time = Integer.parseInt(input[3]);

                arrayList[start].add(new Destination(dest, fee, time));
            }

            int[] distance = new int[N + 1];
            int[] cost = new int[N + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            boolean[] visited = new boolean[N + 1];
            PriorityQueue<Destination> queue = new PriorityQueue<>();
            distance[1] = 0;
            cost[1] = 0;
            queue.add(new Destination(1, 0, 0));
            while (!queue.isEmpty()){
                Destination current = queue.poll();
                if (visited[current.dest]){
                    continue;
                }
                visited[current.dest] = true;
                for (int i = 0; i < arrayList[current.dest].size(); i++){
                    Destination next = arrayList[current.dest].get(i);
                    if (distance[next.dest] > distance[current.dest] + next.time){
                        distance[next.dest] = distance[current.dest] + next.time;
                        cost[next.dest] = current.cost + next.cost;
                        queue.offer(new Destination(next.dest, cost[next.dest], distance[next.dest]));
                    }
                }
            }
            if (cost[N] >= fee){
                System.out.println("Poor KCM");
            }else {
                System.out.println(distance[N]);
            }
        }
    }
}

class Destination implements Comparable<Destination> {
    int dest;
    int cost;
    int time;
    Destination(int dest, int cost, int time) {
        this.dest = dest;
        this.cost = cost;
        this.time = time;
    }
    @Override
    public int compareTo(Destination o) {
        return cost > o.cost ? 1: -1;
    }
}