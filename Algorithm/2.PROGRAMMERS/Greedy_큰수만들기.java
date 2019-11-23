package com.company;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.IntUnaryOperator;

public class Greedy02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String number = scanner.next();
        int k = scanner.nextInt();

        System.out.println(Solution02.solution(number, k));

    }
}
class Solution02 {
    public static String solution(String number, int k) {
        String answer = "";

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < number.length(); i++){
            arrayList.add(number.charAt(i) - '0');
        }

        for (int i = 0; i < k ; i++){//k만큼 반복
            for (int j = 0; j < arrayList.size()-1; j++) {
                if (arrayList.get(j) < arrayList.get(j + 1)){
                    arrayList.remove(j);
                    break;
                }
            }
        }

        if (number.length()-k != arrayList.size()){
            int size = arrayList.size() - (number.length()-k);
            for (int i = 0; i < size; i++){
                arrayList.remove(arrayList.size()-1);
            }
        }

        for (int a : arrayList){
            answer += String.valueOf(a);
        }
        return answer;
    }
}