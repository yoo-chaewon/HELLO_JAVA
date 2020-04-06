import java.util.LinkedList;

public class Solution {
    static int[] student1 = {1, 2, 3, 4, 5};
    static int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public static int[] solution(int[] answers) {
        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) score[0]++;
            if (answers[i] == student2[i % student2.length]) score[1]++;
            if (answers[i] == student3[i % student3.length]) score[2]++;
        }

        int max = 0;
        for (int a : answers) max = Math.max(max, a);

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < score.length; i++) if (max == score[i]) list.add(i + 1);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = list.get(i);

        return answer;
    }
}
