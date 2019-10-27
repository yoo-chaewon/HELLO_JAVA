package com.company;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String dartResult = scanner.next();

        System.out.println(Solution03.solution(dartResult));

    }
}

class Solution03 {
    public static int solution(String dartResult) {
        int answer = 0;
        double[] result = new double[dartResult.length()];
        int cur = 0;


        for (int i = 0; i < dartResult.length(); i++) {
            switch (dartResult.charAt(i)) {
                case 'S':
                    result[cur] = Math.pow(result[cur], 1);
                    cur++;
                    break;
                case 'D':
                    result[cur] = Math.pow(result[cur], 2);
                    cur++;
                    break;
                case 'T':
                    result[cur] = Math.pow(result[cur], 3);
                    cur++;
                    break;
                case '*':
                    if (cur - 2 >= 0) result[cur - 2] *= 2;
                    result[cur - 1] *= 2;
                    break;
                case '#':
                    result[cur-1] *= -1;
                    break;
                default:
                    result[cur] = result[cur] * 10 + dartResult.charAt(i) - '0';
                    break;
            }
        }
        for (double value : result) answer += value;
        return answer;
    }
}