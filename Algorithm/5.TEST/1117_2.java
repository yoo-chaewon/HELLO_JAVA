package com.company;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int N = scanner.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];
        for (int i = 0; i < N; i++){
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++){
            b[i] = scanner.nextInt();
        }

        System.out.println(Solution02.solution(a, b));



    }
}
class  Solution02{
    public static int solution(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int curA = 0;
        int curB = 0;
        int answer = 0;

        for (int i = curA; i < a.length; i++){
            for (int j = curB; j < a.length; j++ ){
                if (a[i] > b[j]) {
                    answer++;
                    curB = j;
                    break;
                }
            }
        }
        return answer;
    }
}
