package com.company;

import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class BP04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String numbers = scanner.next();
        System.out.println(Solution04.solution(numbers));
    }
}

class Solution04 {
    static int answer = 0;

    public static int solution(String numbers) {
        int[] arr = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i) - '0';
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= numbers.length(); i++)
            permutation(set, arr, 0, i);
        isPrime(set);

        return answer;
    }

    public static void isPrime(HashSet<Integer> set) {
        boolean flag;
        for (int key : set) {
            flag = true;
            for (int j = 2; j <= (int) Math.sqrt(key); j++) {
                if (key % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag && key != 1 && key != 0)
               answer++;
        }
    }

    public static void permutation(HashSet<Integer> set, int[] arr, int s, int e) {
        if (s == e) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < e; i++) {
                sb.append(arr[i]);
            }
            set.add(Integer.parseInt(sb.toString()));
        } else {
            for (int i = 0; i + s < arr.length; i++) {
                swap(arr, s, s + i);
                permutation(set, arr, s + 1, e);
                swap(arr, s, s + i);
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
