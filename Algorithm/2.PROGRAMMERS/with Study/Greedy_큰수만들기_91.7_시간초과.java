import java.util.ArrayList;

class Solution {
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < number.length(); i++){
            arrayList.add(number.charAt(i) - '0');
        }

        for (int i = 0; i < k; i++){
            for (int j = 0; j < arrayList.size()-1; j++){
                if (arrayList.get(j) < arrayList.get(j+1)){
                    arrayList.remove(j);
                    break;
                }
            }
        }

        for (int i =0; i < number.length()-k; i++) answer.append(arrayList.get(i));
        return answer.toString();
    }
}