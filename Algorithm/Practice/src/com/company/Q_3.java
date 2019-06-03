package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/49993
public class Q_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String skill = bufferedReader.readLine();//CBD

        int size = Integer.parseInt(bufferedReader.readLine());
        String[] skill_tree;
        skill_tree = bufferedReader.readLine().split(" ");
        System.out.println(Solution3.solution3(skill, skill_tree));
    }
}

class Solution3 {
    public static int solution3(String skill, String[] skill_trees) {
        int answer = 0;
        int none = 0;
        char[] skill_arr = skill.toCharArray();//CBD
        for (int k = 0; k < skill_trees.length; k++) {
            int max = -1;
            Queue<Character> queue = new LinkedList<>();
            String temp = skill_trees[k];
            for (int i = 0; i < temp.length(); i++) {
                ((LinkedList<Character>) queue).offerLast(temp.charAt(i));
            }

            boolean flag = false;
            while (!queue.isEmpty()) {
                if (flag) break;
                char pop_skill = ((LinkedList<Character>) queue).pollFirst();
                int before_max = max;
                for (int i = 0; i < skill_arr.length; i++) {
                    if (pop_skill == skill_arr[i]) {
                        max = i;
                        if (before_max > max || before_max-max <= -2) {
                            none++;
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }
        answer = skill_trees.length - none;
        return answer;
    }
}