import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BFSDFS {
    public static void main(String[] args){
        try{
            DFSBFSMain();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //1260_DFS,BFS
    static int[][] map = new int[1001][10001];
    static Boolean[] visited = new Boolean[1001];
    static int N;
    static int M;
    public static void DFSBFSMain() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] f_line = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(f_line[0]);//정점의 개수
        M = Integer.parseInt(f_line[1]);//간선의 개수
        int V = Integer.parseInt(f_line[2]);//시작할 정점의 번호
        for (int i = 1; i <= M; i++){
            String[] node = bufferedReader.readLine().split(" ");
            int A = Integer.parseInt(node[0]);
            int B = Integer.parseInt(node[1]);
            map[A][B] = 1;
            map[B][A] = 1;
        }
        for (int j = 1; j <= N; j++){
            visited[j] = false;
        }
        DFS(V);
        for (int j = 1; j <= N; j++){
            visited[j] = false;
        }
        System.out.println("");
        BFS(V);
    }
    public static void DFS(int V){
        visited[V] = true;
        System.out.print(V + " ");
        for (int i = 1; i <= N; i++) {
            if ((map[V][i] == 1) && (visited[i] == false)){
                visited[i] = true;
                DFS(i);
            }
        }
    }
    public static void BFS(int V){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;
        System.out.print(V + " ");
        while (!queue.isEmpty()){
            int tmp = queue.peek();
            for (int i = 1; i <= N; i++){
                if ((map[tmp][i] == 1) && (visited[i]==false)){
                    visited[i] = true;
                    queue.offer(i);
                    System.out.print(i + " ");
                }
            }
            queue.poll();
        }
    }
}
