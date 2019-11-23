package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class ProgrammersHash3 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        String[][] clothes = new String[num][2];

        for (int i = 0; i < num; i++){
            String[] temp = bufferedReader.readLine().split(" ");
            clothes[i][0] = temp[0];
            clothes[i][1] = temp[1];
        }

        System.out.println(Solution03.solution(clothes));
    }
}

class Solution03 {
    public static int solution(String[][] clothes) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) +1);
        }
        int sum = 1;
        for (String key: map.keySet()){
            sum *= (map.get(key) + 1);
        }
        return sum -1;
    }
}
