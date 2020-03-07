import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int a : priorities) queue.add(a);

        Arrays.sort(priorities);
        int index = priorities.length - 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == priorities[index]) {
                index--;
                answer++;

                if (location == 0) return answer;
                else location--;
            } else {
                queue.add(cur);
                location = (location == 0) ? queue.size() - 1 : --location;
            }
        }
        return answer+1;
    }
}