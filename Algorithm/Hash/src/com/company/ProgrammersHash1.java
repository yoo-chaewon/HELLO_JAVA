package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ProgrammersHash1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int participantNum = Integer.parseInt(bufferedReader.readLine());
        String[] participant = new String[participantNum];
        for (int i = 0; i < participantNum; i++){
            participant[i] = bufferedReader.readLine();
        }
        int completionNum = Integer.parseInt(bufferedReader.readLine());
        String[] completion = new String[completionNum];
        for (int i = 0; i < completionNum; i++){
            completion[i] = bufferedReader.readLine();
        }
        System.out.println(Solution01_2.solution(participant, completion));
    }
}
//효율성 테스트 0점: ArrayList사용
class Solution01_1 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < participant.length; i++){
            list.add(participant[i]);
        }
        for (int i = 0; i < completion.length; i++){
            list.remove(completion[i]);
        }
        for (String a: list){
            answer = a;
        }
        return answer;
    }
}

//효율성 통과
class Solution01_2 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Set<String> hash = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < participant.length; i++){
            if(hash.add(participant[i])){
            }else{
                list.add(participant[i]);
            }
        }
        for (int i = 0; i < completion.length; i++){
            if(hash.remove(completion[i])){
            }else{
                list.remove(completion[i]);
            }
        }
        if (hash.size() > list.size()){
            for (String a: hash){
                answer = a;
            }
        }else {
            for (String a: list){
                answer = a;
            }
        }
        return answer;
    }
}

//좋은코드 참고
class Solution01_3 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String player: participant) hashMap.put(player, hashMap.getOrDefault(player, 0) + 1);
        for (String player: completion) hashMap.put(player, hashMap.get(player) - 1);

        for (String key: hashMap.keySet()){
            if (hashMap.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}