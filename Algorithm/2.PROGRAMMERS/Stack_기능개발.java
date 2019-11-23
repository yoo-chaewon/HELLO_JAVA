package com.company;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class ProgrammersStack2 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[] progresses = new int[size];
        int[] speeds = new int[size];

        for (int i = 0; i < size; i++) progresses[i] = scanner.nextInt();
        for (int i = 0; i < size; i++) speeds[i] = scanner.nextInt();
        for (int result: Solution02.solution(progresses, speeds)) System.out.print(result);
    }
}

class Solution02 {
    public static int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++){
            if ((100 - progresses[i])%speeds[i] > 0){//나머지 있는 경우
                queue.addLast((100 - progresses[i])/speeds[i]+1);
            }else {//나머지 없는 경우
                queue.addLast((100 - progresses[i])/speeds[i]);
            }
        }
        int max = -1;
        int count = 1;
        int cur = -1;
        int[] answer = new int[queue.size()];

        while (true){
            int num = queue.pollFirst();
            if (num > max){
                max = Math.max(max,num);
                answer[++cur] = count;
                count = 1;
            }else{
                answer[cur]++;
            }
            if (queue.isEmpty()) break;
        }
        int[] result = new int[cur+1];
        for (int i = 0; i <= cur; i++){
            result[i] = answer[i];
        }
        return result;
    }
}