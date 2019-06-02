package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//https://programmers.co.kr/learn/courses/30/lessons/42588
public class Q_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = scanner.nextInt();
        }
        int[] result = new int[size];
        result = solution(heights);
        for (int a : result) {
            System.out.print(a + " ");
        }
    }

    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            ((LinkedList<Integer>) queue).offerLast(heights[i]);
        }
        int cur = heights.length ;
        while (!queue.isEmpty()) {
            int current = ((LinkedList<Integer>) queue).pollLast();
            cur--;
            for (int i = cur - 1; i >= 0; i--) {
                if (heights[i] > current) {
                    answer[cur] = i + 1;
                    break;
                }
            }
        }
        return answer;
    }
}
