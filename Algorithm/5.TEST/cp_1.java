import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[][] good1 = {{25400, 2}, {10000, 1}, {31600, 1}};
        int[][] coupon1 = {{5,3}, {23, 2}, {11, 2}, {9, 5}};//입력 확인.

        int[][] good2 = {{3100, 2}, {7700, 1}, {3100, 2}};
        int[][] coupon2 = {{33, 4}};

        System.out.println(Solution.solution(good1, coupon1));
        System.out.println(Solution.solution(good2, coupon2));
    }
}

class Solution {
    public static int solution(int[][] goods, int[][] coupons) {
        int answer = 0;

        Arrays.sort(goods, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < coupons.length; i++) {
            for (int j = 0; j < coupons[i][1]; j++) {
                queue.add(coupons[i][0]);
            }
        }

        for (int i = 0; i < goods.length; i++) {
            for (int j = 0; j < goods[i][1]; j++) {
                double discount = 1;
                if (!queue.isEmpty()) {
                    discount = (100 - queue.poll());
                    discount /= 100;
                }
                System.out.println("test" + discount);
                answer+= discount * goods[i][0];
            }
        }
        return answer;
    }
}