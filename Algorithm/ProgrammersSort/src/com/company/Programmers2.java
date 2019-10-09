package com.company;

import java.io.InputStreamReader;
import java.util.*;

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
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            strArr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if (strArr[0].equals("0")) return "0";

        for (String str: strArr){
            answer += str;
        }

        return answer;
    }
}