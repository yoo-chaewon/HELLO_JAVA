import java.util.Arrays;

class Solution {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        int startIndx = 0;
        int endIndx = people.length-1;
        Arrays.sort(people);

        while (true){
            if (people[startIndx] + people[endIndx] > limit){
                endIndx--;
                answer++;
            }else {
                startIndx++;
                endIndx--;
                answer++;
            }
            if (startIndx > endIndx){
                break;
            }
        }
        return answer;
    }
}