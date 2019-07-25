package com.company;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q_2217 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int num = scanner.nextInt();
        ArrayList<Integer> ropes = new ArrayList<>();
        for (int i = 0; i < num; i++){
            ropes.add(scanner.nextInt());
        }
        Collections.sort(ropes);

        int cur = ropes.size() - 1;
        int result = 0;
        int temp;
        while (cur >= 0) {
            temp = ropes.size() - cur;
            result = Math.max(result, ropes.get(cur)*temp);
            cur--;
        }
        System.out.println(result);
    }
}
