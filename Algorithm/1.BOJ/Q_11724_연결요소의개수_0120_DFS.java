import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);//정점의 개수
        int M = Integer.parseInt(NM[1]);//간선의 개수

        visited = new boolean[N + 1];
        arr = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String[] uv = bufferedReader.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            arr[u].add(v);
            arr[v].add(u);
        }

        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                answer++;
                DFS(i);
            }
        }
        System.out.println(answer);
    }

    public static void DFS(int cur) {
        visited[cur] = true;
        for (int i = 0; i < arr[cur].size(); i++) {
            if (!visited[arr[cur].get(i)]) {
                DFS(arr[cur].get(i));
            }
        }
    }
}
