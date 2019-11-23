package com.company;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
* 차이가 제일 적은 걸로
*
* */
public class Test05 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(Solution05.solution(arr));
    }
}

class  Solution05{
    public static int solution(int[] arr){
        int answer = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            int index = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < result.size(); j++){
                if (arr[i] < result.get(j)){
                    if (min > result.get(j) - arr[i]){
                        min = result.get(j) - arr[i];
                        index = j;
                    }
                }
            }

            if (index == -1) {
                result.add(arr[i]);
            }else {
                result.remove(index);
                result.add(arr[i]);
            }
            System.out.println(result);
        }
        return result.size();
    }
}
