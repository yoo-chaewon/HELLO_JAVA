package com.company;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class ProgrammersStack4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int num = scanner.nextInt();
        int[] prices = new int[num];
        for (int i = 0; i < num; i++){
            prices[i] = scanner.nextInt();
        }
        for (int a: Solution04.solution(prices)){
            System.out.print(a);
        }

        for (int a: Solution04_2.solution(prices)){
            System.out.print(a);
        }
    }
}
class Solution04 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int a: prices){
            queue.addLast(a);
        }
        int cur = 0;
        while (!queue.isEmpty()){
            int num = queue.pollFirst();
            int count = 0;
            for (int i = cur+1; i < prices.length; i++) {
                if (num <= prices[i]) count++;
                else {
                    count++;
                    break;
                }
            }
            answer[cur] = count;
            cur++;
        }
        return answer;
    }
}

class Solution04_2 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int cur = 0;
        for (int i = cur; i < prices.length-1; i++){
            int count = 0;
            for (int j = i+1; j < prices.length; j++){
                if (prices[i] <= prices[j]) count++;
                else {
                    count++;
                    break;
                }
            }
            answer[i] = count;
            cur++;
        }
        return answer;
    }
}