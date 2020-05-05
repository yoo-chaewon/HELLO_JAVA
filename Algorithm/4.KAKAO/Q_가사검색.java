class Solution {
    public static void main(String[] args) {
        for (int a : solution(new String[] {"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"})){
            System.out.println(a);
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int index = 0;
        for (int i = 0; i < queries.length; i++){
            int count = 0;
            for (int j = 0; j < words.length; j++){
                if (queries[i].length() != words[j].length()) continue;
                count++;
                for (int k = 0; k < queries[i].length(); k++) {
                    if (queries[i].charAt(k) != '?' && queries[i].charAt(k) != words[j].charAt(k)) {
                        count--;
                        break;
                    }
                }
            }
            answer[index++] = count;
        }
        return answer;
    }
}