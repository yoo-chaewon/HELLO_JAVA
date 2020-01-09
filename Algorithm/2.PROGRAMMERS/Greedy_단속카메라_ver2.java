import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a,b) -> Integer.compare(a[0], b[0]));
        int end = routes[0][1];
        for (int i = 0; i < routes.length-1; i++){
            end = Math.min(end, routes[i][1]);
            if (end < routes[i+1][0]){
                answer++;
                end = routes[i+1][1];
            }
        }
        return answer;
    }
}
