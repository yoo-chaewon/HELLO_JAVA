package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q_1753_PQ {
    static int INF = 214783647;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] VE = bufferedReader.readLine().split(" ");
        int vertex = Integer.parseInt(VE[0]);
        int edge = Integer.parseInt(VE[1]);

        int start = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Node>[] arrayList = new ArrayList[vertex+1];
        for (int i = 1; i < vertex+1; i++){
            arrayList[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < edge; i++){
            String[] data = bufferedReader.readLine().split(" ");
            int from = Integer.parseInt(data[0]);
            int to = Integer.parseInt(data[1]);
            int weight = Integer.parseInt(data[2]);
            arrayList[from].add(new Node(to, weight));
        }
        int[] distance = new int[vertex+1];
        Boolean[] visited = new Boolean[vertex+1];
        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);
        distance[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (visited[node.dest]){
                continue;
            }
            visited[node.dest] = true;
            for (Node next : arrayList[node.dest]){
                if (visited[next.dest] == false){
                    distance[next.dest] = Math.min(distance[next.dest], distance[node.dest] + next.weight);
                    queue.offer(new Node(next.dest, distance[next.dest]));
                }
            }
        }

        for (int i = 1; i < vertex+1; i++){
            if (distance[i] == INF){
                System.out.println("INF");
            }else {
                System.out.println(distance[i]);
            }
        }
    }
}
class Node implements Comparable<Node>{
    int dest;
    int weight;
    Node(int dest, int weight){
        this.dest = dest;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        return this.weight > o.weight ? 1: -1;
    }
}

