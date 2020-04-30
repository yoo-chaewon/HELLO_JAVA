import java.util.*;
//효율성0점 / 총정 64.1
public class Solution {
    static int min = Integer.MAX_VALUE;
    public static int solution(int[] stones, int k) {
        int answer = 0;

        while (true){
            if (!Check(stones,k)) break;
            answer+=min;
            for (int i = 0; i < stones.length; i++){
                if (stones[i] != 0) stones[i]-=min;
            }
        }
        return answer;
    }

    public static boolean Check(int[] stones, int k){
        int count = 0;
        for (int i = 0; i < stones.length; i++){
            if (stones[i] != 0) min = Math.min(min, stones[i]);
            if (count == k) return false;
            if (stones[i] == 0){
                count++;
            }else {
                count = 0;
            }
        }
        if (count == k) return false;
        return true;
    }
}