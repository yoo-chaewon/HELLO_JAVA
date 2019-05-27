package com.company;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q_1865 {
    static ArrayList<Dot>[] arrayLists;
    static int N;
    static int MAX = Integer.MAX_VALUE;
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

            int w_start = 0;
            int w_dest = 0;
            int w_cost = 0;
            for (int c = 0; c < W; c++){
                String[] w_data = bufferedReader.readLine().split(" ");
                w_start = Integer.parseInt(w_data[0]);
                w_dest = Integer.parseInt(w_data[1]);
                w_cost = Integer.parseInt(w_data[2]);
                arrayLists[w_start].add(new Dot(w_dest, w_cost));
            }
            int result = (w_cost*-1) + WormHole(w_dest, w_start);
            if (result < 0){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
    public static int WormHole(int start, int dest){
        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];
        Arrays.fill(distance, MAX);

        PriorityQueue<Dot> queue = new PriorityQueue<>();
        queue.offer(new Dot(start, 0));
        distance[start] = 0;
        while (!queue.isEmpty()){
            Dot current = queue.poll();
            if (visited[current.dest]){
                continue;
            }
            visited[current.dest] = true;
            for (Dot next: arrayLists[current.dest]){
                if (visited[next.dest] == false) {
                    distance[next.dest] = Math.min(distance[next.dest], distance[current.dest] + next.cost);
                    queue.offer(new Dot(next.dest, distance[next.dest]));
                }
            }
        }
        return distance[dest];
    }
}
class Dot implements Comparable<Dot>{
    int dest;
    int cost;
    Dot(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Dot o) {
        return this.cost > o.cost ? 1: -1;
    }
}