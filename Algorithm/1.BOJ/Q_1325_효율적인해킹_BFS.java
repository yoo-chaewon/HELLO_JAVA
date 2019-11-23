package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q_1325_BFS {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int node = Integer.parseInt(input[0]);
        int branch = Integer.parseInt(input[1]);
        ArrayList<Integer>[] arrayLists = new ArrayList[node + 1];
        for (int i = 0; i < node + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < branch; i++) {
            String[] data = bufferedReader.readLine().split(" ");
            arrayLists[Integer.parseInt(data[1])].add(Integer.parseInt(data[0]));
        }

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> count_arr = new ArrayList<>();
        for (int i = 1; i < node + 1; i++) {
            int count = 0;
            ((LinkedList<Integer>) queue).add(i);
            int[] visited = new int[node + 1];
            while (queue.isEmpty() == false) {
                count++;
                int temp = queue.poll();
                visited[temp] = 1;
                for (int j = 0; j < arrayLists[temp].size(); j++) {
                    if (visited[arrayLists[temp].get(j)] == 0) {
                        ((LinkedList<Integer>) queue).add(arrayLists[temp].get(j));
                    }
                }
            }
            count_arr.add(count);
        }

        int min = 0;
        for (int i = 0; i < count_arr.size(); i++) {
            if (count_arr.get(i) > min) {
                min = count_arr.get(i);
            }
        }

        for (int i = 0; i < count_arr.size(); i++) {
            if (count_arr.get(i) == min) {
                System.out.print(i + 1 + " ");
            }
        }
    }
}
