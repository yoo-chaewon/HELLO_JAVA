import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args){
        System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int[] arr = new int[n+1];
        ArrayList<Integer>[] arrayLists = new ArrayList[n+1];
        for (int i = 0 ; i <= n; i++){
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++){
            arrayLists[edge[i][0]].add(edge[i][1]);
            arrayLists[edge[i][1]].add(edge[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        arr[1] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < arrayLists[cur].size(); i++) {
                int next = arrayLists[cur].get(i);
                if (arr[next] == 0) {
                    arr[next] = arr[cur] + 1;
                    queue.add(next);
                    max = Math.max(max, arr[next]);
                }
            }
        }

        for (int a: arr){
            if (a == max) answer++;
        }
        return answer;
    }
}