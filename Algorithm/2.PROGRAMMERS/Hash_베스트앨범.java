package com.company;

import java.io.InputStreamReader;
import java.util.*;

public class ProgrammersHash4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int size = scanner.nextInt();
        String[] genres = new String[size];
        int[] plays = new int[size];
        for (int i = 0; i < size; i++) {
            genres[i] = scanner.next();
        }
        for (int i = 0; i < size; i++) {
            plays[i] = scanner.nextInt();
        }
        for (int a : Solution04.solution(genres, plays)) {
            System.out.print(a);
        }
    }
}

class Solution04 {
    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<String> key = new HashSet<>();
        HashMap<String, Integer> genresSum = new HashMap<>();
        HashMap<String, LinkedHashMap<Integer, Integer>> list = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            key.add(genres[i]);
            genresSum.put(genres[i], genresSum.getOrDefault(genres[i], 0) + plays[i]);
            if (list.get(genres[i]) == null) {
                list.put(genres[i], new LinkedHashMap<>());
            }
            list.get(genres[i]).put(i, plays[i]);
        }

        while (key.size() > 0) {
            String maxKey = "";
            int max = -1;
            for (String tKey : key) {
                if (max < genresSum.get(tKey)) {
                    max = genresSum.get(tKey);
                    maxKey = tKey;
                }
            }
            ArrayList<Integer> sorted = SortByValue(list.get(maxKey));
            if (sorted.size() == 1){
                result.add(sorted.get(0));
            }else{
                result.add(sorted.get(0));
                result.add(sorted.get(1));
            }
            key.remove(maxKey);
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static ArrayList SortByValue(HashMap<Integer, Integer> map){
        ArrayList<Integer> key = new ArrayList();
        key.addAll(map.keySet());

        Collections.sort(key, new Comparator(){
            public int compare(Object o1, Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v2).compareTo(v1);
            }
        });

        return key;
    }
}







