import java.util.HashSet;

public class Solution {
    static HashSet<String> set = new HashSet<>();
    public static int solution(int[][] baseball) {
        String number = "123456789";
        boolean[] visited = new boolean[number.length()];
        Play(baseball, number, visited, 0, "");
        return set.size();
    }

    public static boolean Check(int[][] baseball, String str) {
        for (int[] arr : baseball){
            int strike = 0;
            int ball = 0;
            String suggest = String.valueOf(arr[0]);
            for (int i = 0; i < 3; i++){
                if (suggest.charAt(i) == str.charAt(i)) strike++;
                else {
                    if (str.contains(Character.toString(suggest.charAt(i)))) ball++;
                }
            }
            if (strike != arr[1] || ball != arr[2]) return false;
        }
        return true;
    }

    public static void Play(int[][] baseball, String number, boolean[] visited, int depth, String result) {
        if (depth == 3) {
            if (Check(baseball, result)) {
                set.add(result);
                return;
            }
        }

        for (int i = 0; i < number.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                Play(baseball, number, visited, depth + 1, result + number.charAt(i));
                visited[i] = false;
            }
        }
    }
}
