import java.util.*;
class Solution {
    public int[] solution(String s) {
        ArrayList<String> arrayList = new ArrayList<>();
        String temp = "";
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '{') {
                temp = "";
            } else if (s.charAt(i) == '}') {
                arrayList.add(temp);
            } else {
                temp += s.charAt(i);
            }
        }

        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.split(",").length - o2.split(",").length;
            }
        });

        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        for (String cur : arrayList){
            String[] cur_list = cur.split(",");
            for (int j = 0; j < cur_list.length; j++){
                if (!result.contains(cur_list[j])) result.add(Integer.parseInt(cur_list[j]));
            }
        }

        int[] answer = new int[result.size()];
        int index = 0;
        for (int key : result){
            answer[index++] = key;
            if (index == result.size()) break;
        }
        return answer;
    }
}