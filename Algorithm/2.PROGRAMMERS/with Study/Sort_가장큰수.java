import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] numberStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            numberStr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(numberStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if (numberStr[0].equals("0")) return "0";

        for (String str : numberStr) answer.append(str);

        return answer.toString();
    }
}