package com.company;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        System.out.println(Solution01.solution(k, x));
    }
}
//연속된 수 k개 중 한개 뺀 값의 합 -> x
class Solution01 {
    public static int solution(int k, int x) {
        int start = -1;
        while (true) {
            start++;
            for (int i = 0; i < k; i++){
                int sum = 0;

                for (int j = 0; j < k; j++){
                    if (i != j){
                        sum += (start + j);
                    }
                }
                if (sum == x) return start + i;
            }
        }
    }
}