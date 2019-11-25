import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        int[] arr = {4,1,2};
        if (n == 1) return "1";
        if (n == 2) return "2";
        if (n == 3) return "4";

        while (n != 0){

            int mod = n % 3;
            if (mod == 0) n--;

            n /= 3;

            answer = arr[mod] + answer;
        }
        return answer;
    }
}