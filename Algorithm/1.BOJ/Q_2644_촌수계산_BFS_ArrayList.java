import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        n = scanner.nextInt();
        map = new ArrayList[n];
        visited = new boolean[n];
        result = new int[n];

        int start = scanner.nextInt();
        int end = scanner.nextInt();

        for (int i = 0; i < n; i++){
            map[i] = new ArrayList<>();
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map[a-1].add(b-1);
            map[b-1].add(a-1);
        }

        BFS(start-1, end-1);
        if (result[end-1] == 0) System.out.println(-1);
        else System.out.println(result[end-1]);
    }

    public static void BFS(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            if (cur == end) return;

            for (int i = 0; i < map[cur].size(); i++){
                if (!visited[map[cur].get(i)]){
                    queue.add(map[cur].get(i));
                    visited[map[cur].get(i)] = true;
                    result[map[cur].get(i)] = result[cur] + 1;
                }
            }
        }
    }
}