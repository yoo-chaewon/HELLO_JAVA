import java.util.*;

public class Solution {
    static HashMap<Long, Long> room_map = new HashMap<>();
    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = getParent(room_number[i]);
        }
        return answer;
    }

    public static long getParent(long room) {
        if (!room_map.containsKey(room)) {
            room_map.put(room, room + 1);
            return room;
        } else {
            room_map.put(room, getParent(room_map.get(room)));
            return room_map.get(room);
        }
    }
}