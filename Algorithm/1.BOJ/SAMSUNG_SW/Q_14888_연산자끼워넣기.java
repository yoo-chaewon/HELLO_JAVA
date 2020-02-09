import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static char[] operators = {'+', '-', '*', '/'};
    static int N;
    static int[] operand;
    static int maxAnswer = Integer.MIN_VALUE;
    static int minAnswer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        N = scanner.nextInt();
        operand = new int[N];

        for (int i = 0; i < N; i++) {
            operand[i] = scanner.nextInt();
        }

        char[] operator = new char[N - 1];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            int number = scanner.nextInt();
            for (int j = 0; j < number; j++) {
                operator[index++] = operators[i];
            }
        }

        boolean[] visited = new boolean[N - 1];
        String result = "";
        Permutation(0, operator, visited, result);

        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }

    public static void Permutation(int depth, char[] operator, boolean[] visited, String result) {
        if (depth == N - 1) {
            minAnswer = Math.min(minAnswer, Calculation(operand, result));
            maxAnswer = Math.max(maxAnswer, Calculation(operand, result));

            return;
        }

        for (int i = 0; i < operator.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Permutation(depth + 1, operator, visited, result + operator[i]);
                visited[i] = false;
            }
        }
    }

    public static int Calculation(int[] operand, String operator) {
        int result = operand[0];
        for (int i = 0; i < operator.length(); i++) {
            char curOper = operator.charAt(i);

            switch (curOper) {
                case '+':
                    result += operand[i + 1];
                    break;
                case '-':
                    result -= operand[i + 1];
                    break;
                case '*':
                    result *= operand[i + 1];
                    break;
                case '/':
                    result /= operand[i + 1];
                    break;
            }
        }
        return result;
    }
}