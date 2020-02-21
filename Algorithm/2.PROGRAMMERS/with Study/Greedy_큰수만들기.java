class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int startIndex = 0;
        int length = number.length() - k;
        int endIndex = number.length()-length+1;

        for (int i = 0 ; i < number.length()-k; i++){
            int max = Integer.MIN_VALUE;
            int index = 0;
            for (int j = startIndex; j < endIndex+i; j++){
                if (max < number.charAt(j)-'0'){
                    max = number.charAt(j)-'0';
                    index = j;
                }
            }
            answer.append(max);
            startIndex = index+1;
        }
        return answer.toString();
    }
}