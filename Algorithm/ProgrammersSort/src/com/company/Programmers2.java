package com.company;

import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Programmers2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++){
            numbers[i] = scanner.nextInt();
        }
        System.out.println(Solution02.solution(numbers));
    }
}
class Solution02 {
    public static String solution(int[] numbers) {
        String answer = "";
        int cur = 0;
        int[] result = new int[numbers.length];

        for (int i = cur; i < numbers.length; i++){
            for (int j = i+1; j < numbers.length; j++){

            }
            int index = i;
            Collections.swap(numbers, i ,j);
//            result[cur++] =
        }

        return answer;
    }
}