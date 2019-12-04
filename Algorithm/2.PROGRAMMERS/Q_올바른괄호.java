import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<Character>();

        for(int i = 0 ; i < s.length(); i++){
            char temp = s.charAt(i);
            switch(temp){
                case '(':
                    stack.push(temp);
                    break;
                case ')':
                    if(stack.isEmpty()){
                        return false;
                    }else{
                        stack.pop();
                    }
                    break;
            }
        }

        if(!stack.isEmpty()) answer = false;
        return answer;
    }
}