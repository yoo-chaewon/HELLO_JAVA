package com.company;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] waiting = new int[size];
        for (int i = 0; i < size; i++) {
            waiting[i] = scanner.nextInt();
        }
        waiting = Solution3.solution(waiting);
        for (int a : waiting){
            System.out.print(a + " ");
        }
    }
}

class Solution3 {
    public static int[] solution(int[] waiting) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < waiting.length; i++) {
            hashSet.add(waiting[i]);
        }

        int[] result = new int[hashSet.size()];
        int j = 0;
        for (int value : hashSet) {
            result[j++] = Integer.valueOf(value);
        }
        return result;
    }
}