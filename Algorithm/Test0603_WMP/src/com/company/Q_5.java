package com.company;
import java.util.Scanner;

public class Q_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] map = new int[size];
        for (int i = 0; i < size; i++) {
            map[i] = scanner.nextInt();
        }
        System.out.println(Solution5.solution(map));
    }
}

class Solution5 {
    static int[] action = {0, 1, 2};//buy, sell, X
    static int max = -1;

    public static int solution(int[] gold_prices) {
        max = -1;
        DFS(false, 0, 0, 0, gold_prices);
        int temp = max;
        max = -1;
        DFS(false, 2, 0, 0, gold_prices);
        int answer = Math.max(max, temp);
        return answer;
    }

    public static void DFS(boolean have, int action, int cur, int point, int[] gold_prices) {
        if (cur >= gold_prices.length) {
            max = Math.max(max, point);
            return;
        }
        if (action == 0) {//buy
            if (!have) {
                DFS(true, 1, cur + 1, point - gold_prices[cur], gold_prices);//sell
                DFS(true, 2, cur + 1, point - gold_prices[cur], gold_prices);//X
            }
        } else if (action == 1) {//sell
            if (have) {
                DFS(false, 2, cur + 1, point + gold_prices[cur], gold_prices);//X
            }
        } else if (action == 2) {//X
            if (!have) {//갖고 있지 X
                DFS(have, 0, cur + 1, point, gold_prices);//buy
                DFS(have, 2, cur + 1, point, gold_prices);
            } else {//have
                DFS(have, 1, cur + 1, point, gold_prices);
                DFS(have, 2, cur + 1, point, gold_prices);
            }
        }
    }
}

