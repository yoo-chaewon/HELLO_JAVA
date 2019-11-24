class Solution {
    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length()/2; i++){
            String result = "";
            String str1 = s.substring(0, i);
            int count = 1;

            for (int j = i; j <= s.length()-i; j+=i){
                String str2 = s.substring(j, j+i);
//                System.out.println(str1 + "랑" + str2);

                if (str1.equals(str2)){
                    count++;
                }else{
                    if (count != 1) result+=count;
                    result += str1;
//                    System.out.println("결과 " + result);

                    str1 = str2;
                    count = 1;
                }
            }
            if (count != 1) result+=count;
            result += str1;

            if (s.length()/ i != 0){
                result += s.substring((s.length()/i)*i);
            }
            // System.out.println(result);
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}