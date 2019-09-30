package com.company;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BP01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = scanner.nextInt();
        }

        for (int a : Solution01.solution(answer)) {
            System.out.print(a);
        }
    }
}

class Solution01 {
    public static int[] solution(int[] answers) {
        int[] result = new int[3];
        ArrayList<Integer> resultArr = new ArrayList();
        int[] kid1 = {1, 2, 3, 4, 5};
        int[] kid2 = {0, 1, 0, 3, 0, 4, 0, 5};
        int[] kid3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == kid1[i % 5]) result[0]++;
            if ((i == 0 || i % 2 == 0) && answers[i] == 2) result[1]++;
            if (i % 2 == 1 && (answers[i] == kid2[i % 8])) result[1]++;
            if (answers[i] == kid3[i % 10]) result[2]++;
        }

        int max = -1;
        for (int i = 0; i < result.length; i++){
            max = Math.max(max, result[i]);
        }
        for (int i = 0; i < result.length; i++){
            if (max == result[i]){
                resultArr.add(i+1);
            }
        }
        int[] answer = new int[resultArr.size()];
        for (int i = 0; i < resultArr.size(); i++){
            answer[i] = resultArr.get(i);
        }
        return answer;
    }
}
