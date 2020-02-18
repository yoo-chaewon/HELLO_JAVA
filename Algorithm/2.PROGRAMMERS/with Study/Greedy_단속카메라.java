import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        int end = routes[0][1];
        for (int i = 1; i < routes.length-1; i++){
            end = Math.min(routes[i][1], end);
            if (end < routes[i+1][0]) {
                end = routes[i+1][1];
                answer++;
            }
        }
        return answer;
    }
}