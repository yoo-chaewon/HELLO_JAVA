package com.company;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String s = scanner.next();
        System.out.println("\n" + Solution04.solution(s));
    }
}

class Solution04 {
    public static int solution(String s) {
        int size = 0;
        int min = Integer.MAX_VALUE;
        while (true) {
            size++;
            Queue<Character> queue = new LinkedList<>();
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                queue.add(s.charAt(i));
            }

            int count = 1;
            String prev = "";

            for (int i = 0; i < size; i++) {
                prev += queue.poll();
            }
            while (!queue.isEmpty()) {
                String current = "";
                if (queue.size() < size){
                    for (int i = 0; i < queue.size(); i++) {
                        current += queue.poll();
                    }
                }else {
                    for (int i = 0; i < size; i++) {
                        current += queue.poll();
                    }
                }


                if (prev.equals(current)) {
                    count++;
                } else {
                    if (count != 1) {
                        result++;
                        result += current.length();
                        System.out.print(count);
                        System.out.print(prev);
                    } else {
                        result += size;
                        System.out.print(prev);
                    }
                    count = 1;
                }

                prev = current;

                if (queue.isEmpty()) {
                    if (count != 0 && count != 1) {
                        result++;
                        result += current.length();
                        System.out.print(count);
                        System.out.print(prev);
                    } else {
                        result += current.length();
                        System.out.print(prev);
                    }
                }
            }

            min = Math.min(min, result);
            if (size > s.length() / 2 - 1) {
                break;
            }
            System.out.println();
        }

        return min;
    }
}
