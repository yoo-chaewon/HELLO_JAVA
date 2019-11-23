package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//LCS2
public class Q_9252 {
    static String input1;
    static String input2;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        input1 = bufferedReader.readLine();
        input2 = bufferedReader.readLine();
        map = new int[input2.length() + 1][input1.length() + 1];
        for (int i = 1; i <= input2.length(); i++) {
            for (int j = 1; j <= input1.length(); j++) {
                if (input2.charAt(i - 1) == input1.charAt(j - 1)) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                } else {
                    map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                }
            }
        }
        System.out.println(map[input2.length()][input1.length()]);
        ArrayList<Character> result = new ArrayList<>();
        int len1 = input1.length();
        int len2 = input2.length();
        while(map[len2][len1] != 0){
            if(map[len2][len1] == map[len2][len1-1]) //왼쪽 비교
                len1--;
            else if(map[len2][len1] == map[len2-1][len1]) //윗쪽 비교
                len2--;
            else if(map[len2][len1] - 1 == map[len2-1][len1-1]) {
                result.add(input1.charAt(len1-1));
                len1--;
                len2--;
            }
        }
        Collections.reverse(result);
        for (char a : result) {
            System.out.print(a);
        }
    }
}
