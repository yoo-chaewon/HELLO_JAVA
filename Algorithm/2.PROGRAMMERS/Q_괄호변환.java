import java.util.*;

class Solution {
    public static String solution(String p) {
        if (p.length() == 0) return "";
        int pos = balance(p);
        String u = p.substring(0, pos + 1);
        String v = p.substring(pos + 1);

        if (isRight(u)) return u += solution(v);
        String tmp = "(";
        tmp += solution(v);
        tmp += ")";
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') tmp += ")";
            else tmp += "(";
        }
        return tmp;
    }

    public static int balance(String w) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < w.length(); i++) {
            char cur = w.charAt(i);
            switch (cur) {
                case '(':
                    left++;
                    break;
                case ')':
                    right++;
                    break;
            }
            if (left == right) return i;
        }
        return -1;
    }

    public static boolean isRight(String w) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < w.length(); i++) {
            switch (w.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}