package com.company;

import java.util.Scanner;

public class Q_2661 {
    static int num;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        DFS("1", 1);
    }
    static boolean flag = false;
    public static void DFS(String result, int depth) {
        if (flag) return;
        if (depth == num) {
            System.out.println(result);
            flag = true;
        }
        for (int i = 1; i <= 3 ; i++) {
            if (Check(result+i)) DFS(result+i, depth + 1);
        }
    }

    public static boolean Check(String str) {
        int len = str.length();
        int start = len - 1;
        int end = len;

        for (int i = 1; i <= len/2; i++) {
            if (str.substring(start - i, end - i).equals(str.substring(start, end))) {
                return false;//중복
            }
            start -= 1;
        }
        return true;
    }
}
