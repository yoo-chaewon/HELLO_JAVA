package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2606 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(bufferedReader.readLine());
        int branch = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st;
        ArrayList<Integer>[] arrayLists = new ArrayList[node+1];
        int[] visited = new int[node+1];

        for (int i = 1; i <= node; i++){
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < branch; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            int data1 = Integer.parseInt(st.nextToken());
            int data2 = Integer.parseInt(st.nextToken());
            arrayLists[data1].add(data2);
            arrayLists[data2].add(data1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arrayLists[1].size(); i++){
            queue.add(arrayLists[1].get(i));
        }
        visited[1] = 1;
        int count = 0;
        while (queue.isEmpty() == false){
            int temp = queue.poll();
            if (visited[temp] != 1){
                visited[temp] = 1;
                count++;
                for (int i = 0; i < arrayLists[temp].size(); i++) {
                    queue.add(arrayLists[temp].get(i));
                }
            }
        }
        System.out.println(count);
    }
}
