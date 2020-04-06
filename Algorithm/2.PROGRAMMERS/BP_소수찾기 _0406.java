import java.util.HashSet;

public class Solution {
    static HashSet<Integer> set = new HashSet<>();
    public static int solution(String numbers) {
        int answer = 0;
        String[] numberArr = numbers.split("");
        boolean[] visited = new boolean[numbers.length()];
        Permutation(numberArr, visited, 0, "0");

        for (int key : set) {
            System.out.println(key);
            if (isPrime(key)) answer++;
        }
        return answer;
    }

    public static void Permutation(String[] numbers, boolean[] visited, int depth, String result) {
        set.add(Integer.parseInt(result));
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Permutation(numbers, visited, depth + 1, result + numbers[i]);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
