package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q_10451 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < cases; i++){
            int num = Integer.parseInt(bufferedReader.readLine());
            String[] data = bufferedReader.readLine().split(" ");
            Cycle(data, num);
        }
    }

    public static void Cycle(String[] data, int num){
        int[] visited = new int[num+1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= num; i++){
            queue.add(i);
        }
        int count = 0;
        while (queue.isEmpty() == false){
            int temp = queue.poll();
            if (visited[temp] == 0){
                visited[temp] = 1;
                int a = Integer.parseInt(data[temp-1]);
                while (true){
                    if (temp == a){
                        count++;
                        break;
                    }
                    else {
                        visited[a]=1;
                        a = Integer.parseInt(data[a-1]);
                    }
                }

            }
        }
        System.out.println(count);
    }
}
