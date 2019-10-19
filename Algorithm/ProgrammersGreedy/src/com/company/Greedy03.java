package com.company;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy03 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[] people = new int[size];
        for (int i = 0; i < size; i++){
            people[i] = scanner.nextInt();
        }
        int limit = scanner.nextInt();
        System.out.println(Solution03.solution(people, limit));
        System.out.println(Solution03_2.solution(people, limit));
    }
}

class Solution03 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int a : people){
            arrayList.add(a);
        }


        for (int i = 0; i < arrayList.size()-1; i++){
            int cur = arrayList.get(i);
            int sum = -1;
            int index = i;
            for (int j = i+1; j < arrayList.size(); j++){
                if (cur + arrayList.get(j) <= limit) {
                    if (sum < cur + arrayList.get(j)){
                        sum = cur + arrayList.get(j);
                        index = j;
                    }
                }
            }
            if (sum == -1){
                answer++;
                arrayList.remove(i);
                i--;
            }else {
                answer++;
                arrayList.remove(index);
                arrayList.remove(i);
                i--;
            }
        }

        return answer + arrayList.size();
    }
}

class Solution03_2 {
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int index = people.length - 1;
        for(int i = 0; i <= index; i++, answer++)
            while (index > i && people[i] + people[index--] > limit)
                answer++;

        return answer;
    }
}
