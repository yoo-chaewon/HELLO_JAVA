package com.company;

import java.io.InputStreamReader;
import java.util.*;

public class Programmers3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[] citations = new int[size];
        for (int i = 0; i < size; i++) citations[i] = scanner.nextInt();

        System.out.println(Solution03.solution(citations));
    }
}

class Solution03 {
    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++){
            if ( i < citations.length - i && citations[i] >= citations.length - i) answer = Math.max(answer, citations.length - i);
        }

        return answer;
    }
}
