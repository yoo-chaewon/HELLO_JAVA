import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int end = routes[0][1];
        for (int i = 0; i < routes.length-1; i++){
            if (end > routes[i][1]) end = routes[i][1];
            if (end < routes[i+1][0]){
                answer++;
                end = routes[i+1][1];
            }
        }
        return answer;
    }
}