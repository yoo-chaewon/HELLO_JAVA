package com.company;

import java.io.InputStreamReader;
import java.util.Scanner;

public class ProgrammersHash2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int num = scanner.nextInt();
        String[] phone_book = new String[num];

        for (int i = 0; i < num; i++){
            phone_book[i] = scanner.next();
        }

        System.out.print(Solution02.solution(phone_book));
    }
}

class Solution02 {
    public static boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length-1; i++){
            for (int j = i+1; j < phone_book.length; j++){
                if (phone_book[j].startsWith(phone_book[i]) || phone_book[i].startsWith(phone_book[j])){
                    return false;
                }
            }
        }
        return true;
    }
}