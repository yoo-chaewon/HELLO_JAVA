import java.util.HashMap;

class Solution {
    static double VALUE = 65536;
    public static int solution(String str1, String str2) {
        HashMap<String, Integer> str1Hash = MakeHash(str1);
        HashMap<String, Integer> str2Hash = MakeHash(str2);

        if (str1Hash.size() == 0 && str2Hash.size() == 0) return (int)VALUE;
        int sum = 0;
        int intersection = 0;

        for (String key : str1Hash.keySet()){
            if (str2Hash.containsKey(key)){
                sum += Math.max(str1Hash.get(key) , str2Hash.get(key));
                continue;
            }
            sum+=str1Hash.get(key);
        }

        for (String key : str2Hash.keySet()){
            if (str1Hash.containsKey(key)){
                intersection += Math.min(str1Hash.get(key) , str2Hash.get(key));
                continue;
            }
            sum += str2Hash.get(key);
        }

        double temp  = (double)intersection/ (double)sum  * VALUE;
        return (int) temp;
    }

    public static HashMap<String, Integer> MakeHash(String str){
        str = str.toLowerCase();
        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'
                    && str.charAt(i + 1) >= 'a' && str.charAt(i + 1) <= 'z') {
                String key = str.substring(i, i+2);
                hash.put(key, hash.getOrDefault(key, 0) + 1);
            }
        }
        return hash;
    }
}