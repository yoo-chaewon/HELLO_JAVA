package com.company;

import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int n = scanner.nextInt();
        int lostSize = scanner.nextInt();
        int[] lost = new int[lostSize];
        for (int i = 0; i < lostSize; i++){
            lost[i] = scanner.nextInt();
        }
        int reserveSize = scanner.nextInt();
        int[] reserve = new int[reserveSize];
        for (int i = 0; i < reserveSize; i++){
            reserve[i] = scanner.nextInt();
        }
        System.out.println(Solution01.solution(n, lost, reserve));
    }
}


class Solution01 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        for (int i = 0; i < lost.length; i++){
            arr[lost[i]-1] --;
        }
        for (int i = 0; i< reserve.length; i++){
            arr[reserve[i]-1]++;
        }

        for (int i = 0; i < arr.length; i++){
            if (i != 0 && arr[i] == 2 && arr[i-1] == 0){
                arr[i]--;
                arr[i-1]++;
            }
            if (i != arr.length - 1 && arr[i] == 2 && arr[i + 1] == 0) {
                arr[i]--;
                arr[i+1]++;
            }
        }

        for (int a:arr){
            if(a > 0) answer++;
        }
        return answer;
    }
}