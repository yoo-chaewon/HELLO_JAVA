package com.company;

import java.io.InputStreamReader;
import java.util.*;

/*
 * HashMap key-value
 * 값 넣기
 * value가 0으로되면 새로운 count++;
 * */
public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(Solution03.solution(arr));
    }
}

class Solution03 {
    public static int solution(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        HashMap<Integer, Integer> key = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int flag = -1;

            for (Integer a : map.keySet()) {
                if (map.get(a) == 0) {
                    flag = a;
                }
            }

            if (flag == -1) {//0인거 없으면
                key.put(arr[i], 0);
                map.put(arr[i], map.get(arr[i]) - 1);
            } else {
                key.remove(flag);
                key.put(arr[i], 0);
            }
        }

        return key.size();
    }
}
