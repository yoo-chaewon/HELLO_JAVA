import java.util.*;
class Solution {
    static int pos;

    public static boolean isOk(String w) {
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        int leftCount = 0;
        int rightCount = 0;
        pos = w.length()+1;

        for (int i = 0; i < w.length(); i++) {
            Character cur = w.charAt(i);

            switch (cur) {
                case '(':
                    leftCount++;
                    stack.push(cur);
                    break;

                case ')':
                    rightCount++;
                    if (!stack.isEmpty())
                        stack.pop();
                    else flag = false;
                    break;
            }

            if (leftCount == rightCount) {//균형잡힌
                pos = Math.min(i + 1, pos);
                if (!flag) return flag;
            }
        }
        return flag;
    }

    public static String solution(String p) {
        if (p.equals("")) return "";
        if (isOk(p)) return p;


        String u = p.substring(0, pos);
        if (isOk(u)) {
            u += solution(p.substring(pos, p.length()));
            return u;
        }

        String answer = "(";
        answer += solution(p.substring(pos, p.length()));
        answer += ")";
        for (int i = 1; i < u.length()-1; i++) {
            switch (u.charAt(i)) {
                case '(':
                    answer += ")";
                    break;
                case ')':
                    answer += "(";
                    break;
            }
        }
        return answer;

    }
}