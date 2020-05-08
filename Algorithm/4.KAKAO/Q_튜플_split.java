import java.util.*;
class Solution {
    public static void main(String[] args){
        for (int a : solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")){
            System.out.println(a);
        }
    }

    public static int[] solution(String s) {
        String[] strArr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(strArr, (a,b)->{return a.length()-b.length();});

        int[] answer = new int[strArr.length];
        int index = 0;
        HashSet<Integer> set = new HashSet<>();
        for (String s1 : strArr){
            for (String s2 : s1.split(",")){
                if (!set.contains(Integer.parseInt(s2))){
                    set.add(Integer.parseInt(s2));
                    answer[index++] = Integer.parseInt(s2);
                }
            }
        }
        return answer;
    }
}