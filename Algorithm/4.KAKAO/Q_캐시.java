import java.util.*;
class Solution {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();
        for (String str : cities){
            String city = str.toLowerCase();
            if (cache.contains(city)){
                answer+=1;
                cache.remove(city);
                cache.add(city);
            }else {
                answer+=5;
                if (cacheSize == 0) continue;
                if (cache.size() >= cacheSize) cache.remove(0);
                cache.add(city);
            }
        }
        return answer;
    }
}