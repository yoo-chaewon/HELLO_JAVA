package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q_1753_PQ {
    static int INF = 99;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        int start = sc.nextInt();

        int[] distance = new int[vertex + 1];
        boolean[] visited = new boolean[vertex + 1];

        ArrayList<Edge>[] a = new ArrayList[vertex + 1];
        for (int i = 1; i <= vertex; i++) {
            distance[i] = INF;
            a[i] = new ArrayList<Edge>();
        }
        distance[start] = 0;

        for (int i = 0; i < edge; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int w = sc.nextInt();
            a[from].add(new Edge(to, w));
        }
        sc.close();

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (visited[current.dest]) {
                continue;
            }
            visited[current.dest] = true;
            for (Edge next : a[current.dest]) {
                if (visited[next.dest] == false) {
                    distance[next.dest] = Math.min(distance[next.dest], distance[current.dest] + next.weight);
                    pq.offer(new Edge(next.dest, distance[next.dest]));
                }
            }
        }

        for (int i = 1; i <= vertex; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
        sc.close();
    }
}

class Edge implements Comparable<Edge> {
    int dest;
    int weight;

    Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

