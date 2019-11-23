package com.company;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.server.ExportException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Test04 {
    public static void main(String[] args) throws Exception {
        BufferedReader stringBuffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = stringBuffer.readLine().split(" ");
        int custom_num = Integer.parseInt(input[0]);
        int room_num = Integer.parseInt(input[1]);
        int[][] customer = new int[custom_num][2];

        for (int i = 0; i < custom_num; i++) {
            String[] custom_info = stringBuffer.readLine().split(" ");
            customer[i][0] = Integer.parseInt(custom_info[0]);
            customer[i][1] = Integer.parseInt(custom_info[1]);
        }

        for (int result : Solution4.solution(customer, room_num)) {
            System.out.print(result + " ");
        }
    }
}

class Solution4 {
    public static int[] solution(int[][] customer, int K) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < customer.length; i++) {
            if (customer[i][1] == 1) {
                set.add(customer[i][0]);
            } else if (customer[i][1] == 0) {
                set.remove(customer[i][0]);
            }
        }
        int[] result = new int[K];
        int j = 0;
        for (int a : set) {
            if (j == K) break;
            result[j++] = a;
        }

        return result;
    }
}
