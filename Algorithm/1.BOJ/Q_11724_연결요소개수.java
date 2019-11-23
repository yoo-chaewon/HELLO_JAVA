package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_11724 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++){
            arr[i] = new ArrayList<>();
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        int count = 0;
        int[] visited = new int[N+1];
        for (int i = 1; i <= N ; i++){
            if (visited[i] == 0){
                count++;
                visited[i] = 1;
                queue.add(i);
                while (queue.isEmpty() == false){
                    int temp = queue.poll();
                        for (int k = 0; k < arr[temp].size(); k++) {
                            if (visited[arr[temp].get(k)] == 0){
                                visited[arr[temp].get(k)] = 1;
                                queue.add(arr[temp].get(k));
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
