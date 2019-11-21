package com.company;

import java.io.InputStreamReader;
import java.util.Scanner;
/*
* 차이가 제일 적은 걸로
*
* */
public class Test05 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

    }
}

class  Solution05{
    public static int solution(int[] a){
        int answer = 0;
        answer = a.length;

        for (int i = 0; i < a.length-1; i++){
            if (a[i] != a[i+1]) answer++;
        }
        return answer;
    }
}
