package com.company;

import java.util.Scanner;

//lotto
public class Q_6603 {
    static int lotto = 6;
    static int[] map;
    static int[] result;
    static int size;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while ((size = scanner.nextInt()) != 0){
            map = new int[size+1];
            result = new int[size+1];
            for (int i = 0; i < size; i++){
                map[i] = scanner.nextInt();
            }
            DFS(0,0);
            System.out.println();
        }
    }
    public static void DFS(int start, int depth){
        if(depth == lotto){
            for (int i = 0; i < lotto; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < size; i++){
            result[depth] = map[i];
            DFS(i+1, depth+1);
        }
    }
}
