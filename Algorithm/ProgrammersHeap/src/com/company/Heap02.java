package com.company;

import java.io.InputStreamReader;
import java.util.*;

//라면공
public class Heap02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int stock = scanner.nextInt();
        int date_size = scanner.nextInt();
        int[] dates = new int[date_size];
        for (int i = 0; i < date_size; i++) {
            dates[i] = scanner.nextInt();
        }
        int supplies_size = scanner.nextInt();
        int[] supplies = new int[supplies_size];
        for (int i = 0; i < supplies_size; i++) {
            supplies[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        System.out.print(Solution02.solution(stock, dates, supplies, k));
    }
}

class Solution02 {
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < stock; i++) {
            queue.add(0);
        }

        int date = -1;
        int cur = -1;
        while (true) {
            date++;
            if (queue.isEmpty()) {
                answer++;
                for (int i = cur + 1; i < dates.length; i++) {
                    if (dates[i] <= date) {
                        priorityQueue.add(supplies[i]);
                        cur = i;
                    }
                }
                int size = priorityQueue.poll();
                for (int i = 0; i < size; i++) {
                    queue.add(0);
                }
            }
            queue.poll();
            k--;

            if (k == 1) break;
        }
        return answer;
    }
}