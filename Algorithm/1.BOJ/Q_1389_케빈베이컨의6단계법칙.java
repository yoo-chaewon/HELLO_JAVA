import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        map = new int[N][N];

        for (int i = 0; i < M; i++){
            String[] input = bufferedReader.readLine().split(" ");
            map[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1] = 1;
            map[Integer.parseInt(input[1])-1][Integer.parseInt(input[0])-1] = 1;
        }

        int resultPerson = N+1;
        int resultNum = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++){
            boolean[] visited = new boolean[N];
            int[] result = new int[N];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            int answer = 0;
            for (int a: BFS(queue, visited, result)){
                answer += a;
            }
            if (resultNum > answer){
                resultPerson = i+1;
            }
            resultNum = Math.min(resultNum, answer);
        }
        System.out.println(resultPerson);
    }

    public static int[] BFS(Queue<Integer> queue, boolean[] visited, int[] result){
        while (!queue.isEmpty()){
            int cur = queue.poll();
            visited[cur] = true;

            for (int i = 0 ; i < N; i++){
                if (map[cur][i] == 1 && !visited[i]){
                    visited[i] = true;
                    result[i] = result[cur]+1;
                    queue.add(i);
                }
            }
        }
        return result;
    }
}