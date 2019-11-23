package com.company;

import java.io.InputStreamReader;
import java.util.*;

public class Programmers1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int num = scanner.nextInt();
        int[] priorities = new int[num];
        for (int i = 0; i < num; i++){
            priorities[i] = scanner.nextInt();
        }
        int location = scanner.nextInt();
        System.out.println(Solution1.solution(priorities, location));

    }
}
class Solution1 {
    public static int solution(int[] priorities, int location) {
        LinkedList<Integer> queue = new LinkedList();
        for (int prio: priorities){
            queue.offer(prio);
        }
        Arrays.sort(priorities);
        int cur = priorities.length - 1;
        int count = 0;
        while (true){
            int temp = queue.poll();
            if (temp != priorities[cur]){
                queue.offer(temp);
//                if (location == 0){
//                    location = queue.size()-1;
//                }else{
//                    location--;
//                }

                location = (location == 0)?queue.size()-1: --location;
            }else{//같다
                cur--;
                count++;
                if (location == 0){
                    return count;
                }else{
                    location--;
                }
            }
        }
    }
}
