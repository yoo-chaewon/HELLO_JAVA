package com.company;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Q_11047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int kind = scanner.nextInt();
        int sum = scanner.nextInt();
        int result = 0;
        ArrayList<Integer> coins = new ArrayList<>();

        for (int i = 0; i < kind; i++) {
            coins.add(scanner.nextInt());
        }
        int cur = coins.size() - 1;
        while (cur >= 0) {
            result += sum / coins.get(cur);
            sum = sum % coins.get(cur);
            cur--;
        }
        System.out.println(result);
    }
}
