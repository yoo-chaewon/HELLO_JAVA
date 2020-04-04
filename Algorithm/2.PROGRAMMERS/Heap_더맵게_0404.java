import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args){
        System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));

    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int a : scoville ) priorityQueue.add(a);

        while (!priorityQueue.isEmpty()){
            int first = priorityQueue.poll();
            if (priorityQueue.isEmpty()){
                if (first < K ) answer = -1;
                break;
            }
            if (first >= K) break;
            int second = priorityQueue.poll();
            int sum = first + second*2;
            priorityQueue.add(sum);
            answer++;
        }
        return answer;
    }
}