package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] map = new int[size];

        for (int i = 0; i < size; i++){
            map[i] = scanner.nextInt();
        }
        int[] result = Solution3.solution(map);
        for (int a : result){
            System.out.print(a + " ");
        }
    }
}
class Solution3 {
    public static int[] solution(int[] waiting) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < waiting.length; i++){
            boolean flag = false;
            for (int j = 0; j < result.size(); j++){
                if (result.get(j) == waiting[i]){//중복있음
                    flag = true;
                    continue;
                }
            }
            if (!flag){
                result.add(waiting[i]);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}