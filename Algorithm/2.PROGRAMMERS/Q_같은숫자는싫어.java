package com.company;

import java.util.Scanner;
//https://programmers.co.kr/learn/courses/30/lessons/12906
public class Q_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++){
            arr[i] = scanner.nextInt();
        }
        for (int a : Solution2.solution2(arr)){
            System.out.print(a + " ");
        }
    }
}

class Solution2 {
    public static int[] solution2(int []arr) {
        int count = 0;
        int[] temp = new int[arr.length];
        temp[0] = arr[0];
        int cur = 0;

        for (int i = 1; i < temp.length; i++){
            if (temp[cur] != arr[i]){
                cur++;
                temp[cur] = arr[i];
                count++;
            }
        }

        int[] answer = new int[count+1];
        for (int i = 0; i < count+1; i++){
            answer[i] = temp[i];
        }
        return answer;
    }
}
