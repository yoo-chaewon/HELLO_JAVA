package com.company;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class ProgrammersStack3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int bridge_length = scanner.nextInt();
        int weight = scanner.nextInt();
        int truck_size = scanner.nextInt();
        int[] truck_weight = new int[truck_size];
        for (int i = 0; i < truck_size; i++) {
            truck_weight[i] = scanner.nextInt();
        }
        System.out.println(Solution03.solution(bridge_length, weight, truck_weight));
    }
}

class Solution03 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) queue.addLast(0);

        int weight_sum = 0;
        for (int i = 0; i < truck_weights.length; i++){
            weight_sum -= queue.pollFirst();
            if (weight_sum + truck_weights[i] <= weight){
                weight_sum += truck_weights[i];
                queue.addLast(truck_weights[i]);
            }else{
                i--;
                queue.addLast(0);
            }
            answer++;
        }
        return answer + bridge_length;
    }
}
