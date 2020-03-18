import java.util.HashMap;

class Solution {
    static double VALUE = 65536;

    public static int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int sum = 0;
        int intersection = 0;

        HashMap<String, Integer> str1Hash = new HashMap<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            if (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z'
                    && str1.charAt(i + 1) >= 'a' && str1.charAt(i + 1) <= 'z') {
                String key = str1.substring(i, i+2);
                str1Hash.put(key, str1Hash.getOrDefault(key, 0) + 1);
                sum++;
            }
        }
        HashMap<String, Integer> str2Hash = new HashMap<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            if (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z'
                    && str2.charAt(i + 1) >= 'a' && str2.charAt(i + 1) <= 'z') {
                String key = str2.substring(i, i+2);
                str2Hash.put(key, str2Hash.getOrDefault(key, 0) + 1);
            }
        }

        if (str1Hash.size() == 0 && str2Hash.size() == 0) return (int)VALUE;
        for (String key : str2Hash.keySet()){
            if (str1Hash.containsKey(key)){
                intersection += Math.min(str1Hash.get(key) , str2Hash.get(key));

                if (str1Hash.get(key) < str2Hash.get(key)){
                    sum -= str1Hash.get(key);
                    sum += str2Hash.get(key);
                }
            }else {
                sum += str2Hash.get(key);
            }
        }
        double temp  = (double)intersection/ (double)sum  * VALUE;
        return (int) temp;
    }
}

