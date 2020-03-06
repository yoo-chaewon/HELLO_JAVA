import java.util.*;
class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> map = new HashSet<>();
        for(int i=0; i<phone_book.length; i++) {
            for(int j=1; j<phone_book[i].length(); j++) {
                map.add(phone_book[i].substring(0,j));
//                System.out.println(phone_book[i].substring(0,j));
            }
        }

        for (int i = 0; i < phone_book.length; i++) {
            if (map.contains(phone_book[i])) {
                answer = false;
            }
        }
        return answer;
    }
}