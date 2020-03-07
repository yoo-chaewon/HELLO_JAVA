import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int weight_sum = 0;
        Queue<Integer> truckQueue = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        for (int truck : truck_weights) truckQueue.add(truck);
        for (int i = 0 ; i < bridge_length; i++)bridge.add(0);

        while (!bridge.isEmpty()) {
            int cur = bridge.poll();
            answer++;
            weight_sum -= cur;

            if (!truckQueue.isEmpty()) {
                if (weight_sum + truckQueue.peek() > weight) {
                    bridge.add(0);
                } else {
                    weight_sum += truckQueue.peek();
                    bridge.add(truckQueue.poll());
                }
            }
        }
        return answer;
    }
}