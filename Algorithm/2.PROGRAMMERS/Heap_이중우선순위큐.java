package com.company;

import java.io.InputStreamReader;
import java.util.*;

public class Heap04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        String[] operations = new String[size];
        for (int i = 0; i < size; i++) {
            operations[i] = scanner.nextLine();
        }

        for (int a : Solution04.solution(operations)) {
            System.out.print(a + " ");
        }

        for (int a : Solution04_2.solution(operations)) {
            System.out.print(a + " ");
        }

    }
}

class Solution04 {
    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String operation : operations) {
            String[] str = operation.split(" ");

            if (str[0].equals("I")) {
                arrayList.add(Integer.parseInt(str[1]));
            }else if (str[0].equals("D")) {
                if (!arrayList.isEmpty()) {
                    if (str[1].equals("-1")) arrayList.remove(0);
                    if (str[1].equals("1")) arrayList.remove(arrayList.size() - 1);
                }
            }

            Collections.sort(arrayList);
        }

        if (arrayList.isEmpty()) return answer;
        if (arrayList.size() == 1) {
            answer[0] = arrayList.get(0);
            answer[1] = arrayList.get(0);
        } else {
            answer[0] = arrayList.get(arrayList.size() - 1);
            answer[1] = arrayList.get(0);
        }
        return answer;
    }
}

class Solution04_2 {
    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> ascending = new PriorityQueue<>();//오름차
        PriorityQueue<Integer> descending = new PriorityQueue<>(Comparator.reverseOrder());//내림차순

        for (String operation : operations) {
            String[] str = operation.split(" ");

            if (str[0].equals("I")) {
                ascending.add(Integer.parseInt(str[1]));
                descending.add(Integer.parseInt(str[1]));
            } else if (str[0].equals("D")) {
                if (!ascending.isEmpty()) {
                    if (str[1].equals("-1")) {
                        descending.remove(ascending.poll());
                    }
                    if (str[1].equals("1")) {
                        ascending.remove(descending.poll());
                    }

                }
            }
        }

        if (!ascending.isEmpty()) {
            answer[0] = descending.poll();
            answer[1] = ascending.poll();
        }
        return answer;
    }
}