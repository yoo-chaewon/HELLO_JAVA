import java.util.*;
class Solution {
    static ArrayList<String> results = new ArrayList<>();
    static int end = 0;
    public static String[] solution(String[][] tickets) {
        HashMap<String, ArrayList> map = new HashMap<>();
        end = tickets.length+1;

        for (int i = 0; i < tickets.length; i++){
            String key = tickets[i][0];
            ArrayList<String> arrayList = new ArrayList<>();
            if (map.containsKey(key)) arrayList = map.get(key);
            arrayList.add(tickets[i][1]);
            Collections.sort(arrayList);
            map.put(key, arrayList);
        }
        Go(map, "ICN", 1, "ICN");
        String[] anwer = results.get(0).split(" ");
        return anwer;
    }

    public static void Go(HashMap<String, ArrayList> map, String key, int depth, String result){
        ArrayList<String> list = map.get(key);
        if (depth == end) {
            results.add(result);
            return;
        }
        if (list == null) return;

        for (int i = 0; i < list.size(); i++){
            String newKey = list.get(i);
            list.remove(i);
            map.put(key, list);
            Go(map, newKey, depth+1, result + " " + newKey);

            list.add(newKey);
            Collections.sort(list);
            map.put(key, list);
        }
    }
}