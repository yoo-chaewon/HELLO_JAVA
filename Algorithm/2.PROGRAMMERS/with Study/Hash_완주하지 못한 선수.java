import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++){
            hashMap.put(participant[i], hashMap.getOrDefault(participant[i], 0 )+1);
        }

        for (int i = 0 ; i < completion.length; i++){
            hashMap.put(completion[i], hashMap.get(completion[i]) -1);
        }

        for (String key : hashMap.keySet()){
            if (hashMap.get(key) > 0 ) answer = key;
        }
        return answer;
    }
}