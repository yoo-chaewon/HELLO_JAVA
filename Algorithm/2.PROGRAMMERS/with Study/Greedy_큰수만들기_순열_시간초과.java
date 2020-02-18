import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static ArrayList<String> arr = new ArrayList<>();

    public static String solution(String number, int k) {
        String answer = "";
        DFS(0, 0, number.length() - k, number, "");

        Collections.sort(arr);
        return arr.get(arr.size()-1);
    }

    public static void DFS(int start, int depth, int size, String number, String result) {
        if (depth == size) {
            arr.add(result);
            return;
        }

        for (int i = start; i < number.length(); i++) {
            DFS(i + 1, depth + 1, size, number, result + number.charAt(i));
        }
    }
}