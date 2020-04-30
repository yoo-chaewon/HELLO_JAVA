import java.util.*;
class Solution {
    static HashSet<String> result_set = new HashSet<>();
    public static int solution(String[] user_id, String[] banned_id) {
        boolean[] visited = new boolean[user_id.length];
        Permutation(user_id, banned_id, visited, 0, "");
        return result_set.size();
    }

    public static void Permutation(String[] user_id, String[] banned_id, boolean[] visited, int depth, String result) {
        if (depth == banned_id.length) {
            if (Check(user_id, banned_id, result)) {
                String[] temp = result.split("");
                Arrays.sort(temp);
                String tmpStr = "";
                for (String str : temp){
                    tmpStr += str;
                }
                result_set.add(tmpStr);
            }
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Permutation(user_id, banned_id, visited, depth + 1, result + i);
                visited[i] = false;
            }
        }
    }
    public static boolean Check(String[] user_id, String[] banned_id, String result) {
        for (int i = 0; i < result.length(); i++) {
            String id = user_id[result.charAt(i) - '0'];
            String banned = banned_id[i];
            for (int j = 0; j < id.length(); j++) {
                if (id.length() != banned.length()) return false;
                if (banned.charAt(j) != '*' && id.charAt(j) != banned.charAt(j)) return false;
            }
        }
        return true;
    }
}