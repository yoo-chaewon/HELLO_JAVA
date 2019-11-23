package com.company;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Programmers1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        int commandSize = scanner.nextInt();
        int[][] commands = new int[commandSize][3];
        for (int i = 0; i < commandSize; i++) {
            for (int j = 0; j < 3; j++) {
                commands[i][j] = scanner.nextInt();
            }
        }
        for (int a : Solution01.solution(array, commands)) {
            System.out.print(a);
        }
    }
}

class Solution01 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int cur = 0;

        for (int i = 0; i < commands.length; i++) {
            int length = commands[i][1] - commands[i][0] + 1;
            int[] temp = new int[length];
            for (int j = 0; j < length; j++){
                temp[j] = array[commands[i][0] -1 + j];
            }
            Arrays.sort(temp);
            answer[cur++] = temp[commands[i][2]-1];
        }
        return answer;
    }
}