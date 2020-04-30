import java.util.*;
//효율성 0점 : 78점
public class Solution {
    public long[] solution(long k, long[] room_number) {
        LinkedHashSet<Long> result = new LinkedHashSet<>();
        for (long number : room_number){
            if (!result.contains(number)){
                result.add(number);
            }else {
                for (long i = number+1; i < k; i++){
                    if (!result.contains(i)){
                        result.add(i);
                        break;
                    }
                }
            }
        }
        long[] answer = new long[room_number.length];
        int cur = 0;
        for (long key : result){
            answer[cur++] = key;
            if (cur == room_number.length) break;
        }
        return answer;
    }
}