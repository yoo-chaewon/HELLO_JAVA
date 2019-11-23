package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        int size = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int [][] customer = new int[size][2];

        for (int i = 0; i < size; i++){
            String[] data = bufferedReader.readLine().split(" ");
            customer[i][0] = Integer.parseInt(data[0]);
            customer[i][1] = Integer.parseInt(data[1]);
        }
        System.out.println(customer.length);

        for (int a: Solution4.solution(customer, k)){
            System.out.print(a + " ");
        }
    }
}
class Solution4 {
    public static int[] solution(int[][] customer, int K) {
        ArrayList<Integer> room = new ArrayList<>();
        Queue<Integer> wait = new LinkedList<>();
        for (int i = 0; i < customer.length; i++){
            if (customer[i][1] == 1 ) {
                if (room.size() < K) room.add(customer[i][0]);
                else ((LinkedList<Integer>) wait).addLast(customer[i][0]);
            }else {//취소
                for (int j = 0; j < room.size(); j++){
                    if (room.get(j) == customer[i][0]){
                        room.remove(j);
                        if (wait.size() >0) {
                            room.add(((LinkedList<Integer>) wait).pollFirst());
                        }
                    }
                }
                for (int j = 0; j < wait.size(); j++){
                    if (((LinkedList<Integer>) wait).get(j) == customer[i][0]){
                        ((LinkedList<Integer>) wait).remove(j);
                    }
                }
            }
        }
        int[] answer = new int[room.size()];
        Collections.sort(room);
        for (int i = 0; i < room.size(); i++){
            answer[i] = room.get(i);
        }
        return answer;
    }
}
