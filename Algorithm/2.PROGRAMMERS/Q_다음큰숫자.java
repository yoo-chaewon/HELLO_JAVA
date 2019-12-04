
class Solution {
    public static int solution(int n) {
        String origin = Integer.toBinaryString(n);
        int originCount = 0;
        for (int i = 0; i < origin.length(); i++){
            if (origin.charAt(i) == '1') originCount++;
        }

        int tempValue = n;
        String temp = " ";
        while (true){
            tempValue++;
            temp = Integer.toBinaryString(tempValue);
            int tempCount = 0;

            for (int i = 0; i < temp.length(); i++){
                if (temp.charAt(i) == '1') tempCount++;
            }
            if (tempCount == originCount) break;
        }
        return  Integer.parseInt(temp, 2);
    }
}