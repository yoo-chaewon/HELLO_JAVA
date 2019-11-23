package com.company;

import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Heap01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[] scoville = new int[size];
        for (int i = 0; i < size; i++){
            scoville[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        System.out.println(Solution01.solution(scoville, k));
    }
}
class Solution01 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int a: scoville){
            queue.add(a);
        }
        while (!queue.isEmpty()){
            if (queue.peek() >= K) break;
            if (queue.size() <= 1) return -1;

            int first = queue.poll();
            int second = queue.poll();
            first = first + (second * 2);
            queue.add(first);
            answer++;
        }
        return answer;
    }
}