import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;
    static int[] countArr;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        parent = new int[N + 1];
        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(input[i]) == 0) parent[i + 1] = i + 1;
            else parent[i + 1] = Integer.parseInt(input[i]);
        }
        countArr = new int[N + 1];
        for (int i = 1; i <= N; i++) countBaby(i);

        int answer = 0;
        while (M-- > 0) {
            String[] nodes = bufferedReader.readLine().split(" ");
            answer += (countArr[Integer.parseInt(nodes[0])] - countArr[Integer.parseInt(nodes[1])]);

        }
        System.out.println(answer);
    }

    public static void countBaby(int node) {
        if (node == parent[node]) return;
        else {
            countArr[parent[node]]++;
            countBaby(parent[node]);
        }
    }
}

