package com.company;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Greedy04 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String name = scanner.next();
        System.out.println(Solution04.solution(name));
        System.out.println(Solution04_2.solution(name));
    }
}


class Solution04 {
    public static int solution(String name) {
        int answer = 0;

        for (int i = 0; i < name.length(); i++){
            int front = name.charAt(i) - 'A';
            int back = 'Z' - name.charAt(i) + 1;

            if (name.charAt(i) != 'A') answer += Math.min(front, back) + 1;
        }
        return --answer;
    }
}

class Solution04_2 {
    public static int solution(String name) {
        int answer = 0;
        int length = name.length() - 1;

        for(int i = 0; i < name.length(); i++){
            int front = name.charAt(i) - 'A';
            int back = 'Z' - name.charAt(i) + 1;
            answer += Math.min(front, back);
            if(name.charAt(i) == 'A'){
                int nextIdx = i+1;
                int countA = 0;
                while (nextIdx < name.length() && name.charAt(nextIdx) == 'A'){
                    countA ++;
                    nextIdx++;
                }
                int tmp = (i-1)*2 + (name.length() -1 -i - countA);
                length = Math.min(length, tmp);
            }
        }
        answer += length;
        return answer;
    }
}
