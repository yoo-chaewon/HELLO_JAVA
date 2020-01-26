import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static int end;
    static ArrayList<Integer>[] map;
    static int result = 0;
    static ArrayList<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        String[] input = bufferedReader.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);
        int count = Integer.parseInt(bufferedReader.readLine());

        map = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        for (int i = 0 ; i < n+1; i++){
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < count ; i++){
            String[] tmp = bufferedReader.readLine().split(" ");
            map[Integer.parseInt(tmp[0])].add(Integer.parseInt(tmp[1]));
            map[Integer.parseInt(tmp[1])].add(Integer.parseInt(tmp[0]));
        }

        DFS(start, visited, 0);
        Collections.sort(results);
        if (results.size() == 0) System.out.println(-1);
        else System.out.println(results.get(0));
    }

    public static void DFS(int num, boolean[] visited, int score){
        if (num == end) {
            results.add(score);
            return;
        }
        score++;
        visited[num] = true;
        for (int i = 0; i < map[num].size(); i++){
            if (!visited[map[num].get(i)]){
                DFS(map[num].get(i), visited, score);
            }
        }
    }
}
