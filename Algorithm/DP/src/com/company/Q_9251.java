package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//LCS
public class Q_9251 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();

        int[][] map = new int[input2.length()+1][input1.length()+1];

        for (int i = 1; i <= input2.length(); i++){
            for (int j = 1; j <= input1.length(); j++){
                if (input2.charAt(i-1) == input1.charAt(j-1)){
                    map[i][j] = map[i-1][j-1] + 1;
                }else {
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                }
            }
        }
        System.out.println(map[input2.length()][input1.length()]);
    }
}
