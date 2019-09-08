package com.company;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class ProgrammersStack1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String arrangment = scanner.nextLine();
        System.out.println(SolutionStack1.solution(arrangment));
    }
}

class SolutionStack1 {
    public static int solution(String arrangement) {
        int answer = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();

        for (int i = 0; i < arrangement.length(); i++){
            if (arrangement.charAt(i) =='('){
                stack.addLast(-1);
            }else{//)
                if (stack.peekLast() == -1){
                    stack.pollLast();
                    stack.addLast(1);
                }else{
                    int num = 0;
                    while (stack.peekLast() != -1){
                        num += stack.pollLast();
                    }
                    stack.pollLast();
                    stack.addLast(num);
                    answer += (num+1);
                }
            }
        }
        return answer;
    }
}
