public class Solution {
    public static void main(String[] args) {
        for (int a : solution(3)){
            System.out.print(a + " ");
        }
    }

    public static int[] solution(int n) {
        StringBuilder result = new StringBuilder("0");
        while ((--n) > 0){
            String tmp = result.toString();
            result.append("0");
            for (int i = tmp.length()-1; i >= 0; i--){
                if (tmp.charAt(i) == '0')result.append(1);
                else result.append(0);
            }
        }

        int[] answer = new int[result.length()];
        for (int i = 0; i < result.length(); i++) {
            answer[i] = result.charAt(i) - '0';
        }
        return answer;
    }
}