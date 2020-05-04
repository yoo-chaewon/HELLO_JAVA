import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public static int solution(int N, int number) {
        HashSet<Integer>[] arr = new HashSet[9];
        int value = N;
        for (int i = 1; i < 9; i++) {
            arr[i] = new HashSet<>();
            arr[i].add(value);
            value = value * 10 + N;
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int a : arr[j]) {
                    for (int b : arr[i - j]) {
                        arr[i].add(a * b);
                        arr[i].add(a + b);
                        arr[i].add(a - b);
                        arr[i].add(b - a);
                        if (a != 0) arr[i].add(b / a);
                        if (b != 0) arr[i].add(a / b);
                        if (arr[i].contains(number)) return i;
                    }
                }
            }
        }
        return -1;
    }
}