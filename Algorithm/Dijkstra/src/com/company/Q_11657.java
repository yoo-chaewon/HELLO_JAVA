package com.company;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q_11657 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bufferedReader.readLine().split(" ");
        int city = Integer.parseInt(NM[0]);
        int bus = Integer.parseInt(NM[1]);
        ArrayList<Dest>[] arrayLists = new ArrayList[city+1];
        for (int i = 1; i <= city; i++){
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < bus; i++){
            String[] input = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int dest = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            arrayLists[start].add(new Dest(dest, cost));
        }
        int[] distance = new int[city+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        for (int k = 1; k <= city; k++){
            for (int i = 1; i <= city; i++){
                for (Dest next : arrayLists[i]){
                    if (distance[i] == Integer.MAX_VALUE) continue;
                    if (distance[next.dest] > distance[i] + next.cost){
                        if (k == city){
                            System.out.println("-1");
                            return;
                        }
                        distance[next.dest] = distance[i] + next.cost;
                    }
                }
            }
        }
        for (int i = 2; i <= city; i++){
            if (distance[i] == Integer.MAX_VALUE){
                System.out.println(-1);
            }else {
                System.out.println(distance[i]);
            }
        }
    }
}
class Dest{
    int dest;
    int cost;
    Dest(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }

}
