import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++){
            int day = (100-progresses[i]) / speeds[i];
            if ((100-progresses[i]) % speeds[i] > 0) day++;
            queue.add(day);
        }

        int count = 1;
        int cur = queue.poll();
        while (true){
            if (cur >= queue.peek()){
                count++;
                queue.poll();
            }else {
                result.add(count);
                count = 1;
                cur = queue.poll();
            }

            if (queue.isEmpty()){
                result.add(count);
                break;
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);

        return answer;
    }
}