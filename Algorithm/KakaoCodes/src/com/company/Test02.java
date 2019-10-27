package com.company;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++){
            arr1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++){
            arr2[i] = scanner.nextInt();
        }

        for (String str: Solution02.solution(n, arr1, arr2)){
            System.out.println(str);
        }
    }
}
class Solution02 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++){
            String map1 = "000000000000000000";
            String map2 = "000000000000000000";
            map1 += Integer.toBinaryString(arr1[i]);
            map2 += Integer.toBinaryString(arr2[i]);

            map1 = map1.substring(map1.length()-n, map1.length());
            map2 = map2.substring(map2.length()-n, map2.length());
            String result = "";
            for(int j = 0; j < n; j++){
                if (map1.charAt(j) == '1' || map2.charAt(j) == '1') result += "#";
                else result+= " ";
            }
            answer[i] = result;
        }
        return answer;
    }
}