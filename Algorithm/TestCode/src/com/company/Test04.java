package com.company;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Test04 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(Solution04.solution(arr));
    }
}
class  Solution04{
    public static int solution(int[] a){
        int answer = 0;
        answer = a.length;

        for (int i = 0; i < a.length-1; i++){
            if (a[i] != a[i+1]) answer++;
        }


        return answer;
    }
}