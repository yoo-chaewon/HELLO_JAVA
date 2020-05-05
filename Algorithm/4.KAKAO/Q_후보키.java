import java.util.HashSet;
class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},
                {"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
    }

    public static int solution(String[][] relation) {
        HashSet<Integer> candidates = new HashSet<>();
        for (int keySet = 1; keySet < (1<<relation[0].length); keySet++){
            HashSet<String> selects = new HashSet<>();
            for (int i = 0; i < relation.length; i++){
                String data = "";
                for (int j = 0; j < relation[i].length; j++){
                    if ((keySet & (1<<j)) != 0){
                        data += relation[i][j] + " ";
                    }
                }
                selects.add(data);
            }
            if (selects.size() == relation.length){
                AddKey(candidates, keySet);
            }
        }
        return candidates.size();
    }

    public static void AddKey(HashSet<Integer> candidates, int keySet){
        for (int key : candidates){
            if ((key & keySet) == key) return;
        }
        candidates.add(keySet);
    }
}