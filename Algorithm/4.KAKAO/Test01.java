package com.company;

import java.io.InputStreamReader;
import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int N = scanner.nextInt();
        int stageSize = scanner.nextInt();
        int[] stages = new int[stageSize];
        for (int i = 0; i < stageSize; i++) {
            stages[i] = scanner.nextInt();
        }

        for (int a : Solution01.solution(N, stages)) {
            System.out.print(a);
        }
    }
}

class Solution01 {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double size = stages.length;
        HashMap<Integer, Double> input_hash = new HashMap<>();
        HashMap<Integer, Double> stage_hash = new LinkedHashMap<>();
        for (int a : stages) {
            input_hash.put(a, input_hash.getOrDefault(a, 0.0) + 1);
        }

        for (int i = 1; i <= N ; i++) {
            if (input_hash.containsKey(i)) {
                double count = input_hash.get(i);
                stage_hash.put(i, count / size);
                size -= count;
            }else{
                stage_hash.put(i, 0.0);
            }
        }

        ArrayList<Integer> result = SortByValue(stage_hash);
        for (int i = 0; i < N; i++){
                answer[i] = result.get(i);
        }
        return answer;
    }

    public static ArrayList SortByValue(HashMap<Integer, Double> map) {
        ArrayList<Integer> key = new ArrayList();
        key.addAll(map.keySet());

        Collections.sort(key, new Comparator() {
            public int compare(Object o1, Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v2).compareTo(v1);
            }
        });
        return key;
    }
}

