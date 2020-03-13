import java.util.*;
class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int a : priorities) pq.add(a);

        while (!pq.isEmpty()){
            for (int i = 0; i < priorities.length; i++){
                if (pq.peek() == priorities[i]) {
                    if (i == location) return answer;
                    answer++;
                    pq.poll();
                }
            }
        }
        return answer;
    }
}