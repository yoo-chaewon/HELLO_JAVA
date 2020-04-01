class Solution {
    static int[] answer;
    public static void make(int size, int cur) {
        if (size / 2 == cur) {
            for (int i = 1; i <= cur; i++) {
                answer[cur+i] = answer[cur-i] == 1? 0: 1;
            }
            return;
        }

        if (cur == 1) {
            answer[cur - 1] = 0;
            answer[cur + 1] = 1;
        }else {
            for (int i = 1; i <= cur; i++) {
                answer[cur+i] = answer[cur-i] == 1? 0: 1;
            }
        }
        make(size, cur * 2 + 1);
    }
}