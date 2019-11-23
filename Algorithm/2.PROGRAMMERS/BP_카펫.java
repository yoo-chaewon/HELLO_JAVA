package com.company;

import java.io.InputStreamReader;
import java.util.Scanner;

public class BP03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int brown = scanner.nextInt();
        int red = scanner.nextInt();

        for (int a : Solution03.solution(brown, red)) {
            System.out.print(a + " ");
        }
    }
}

class Solution03 {
    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int area = brown + red;

        for (int i = 1; i <= red; i++) {
            if (red % i == 0) {
                if ((i + 2) * ((red / i) + 2) == area) {
                    answer[0] = (red / i) + 2;
                    answer[1] = i + 2;

                    return answer;
                }
            }
        }
        return answer;
    }
}