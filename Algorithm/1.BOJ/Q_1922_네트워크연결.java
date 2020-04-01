import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        parent = new int[N+1];
        for (int i = 1; i <= N ; i++) parent[i] = i;

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost-o2.cost;
            }
        });

        for (int i = 0; i < M; i++){
            String[] input = bufferedReader.readLine().split(" ");
            priorityQueue.add(new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }
        int result = 0;
        while (!priorityQueue.isEmpty()){
            Edge cur = priorityQueue.poll();
            if (!isSameParent(cur.v1, cur.v2)){
                result += cur.cost;
                union(cur.v1, cur.v2);
            }
        }
        System.out.println(result);
    }

    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if (a != b){
            parent[a] = b;
        }
    }

    public static boolean isSameParent(int a, int b){
        if (findParent(a) == findParent(b)) return true;
        else return false;
    }

    public static int findParent(int a){
        if (a == parent[a]) return a;
        else return findParent(parent[a]);
    }
}

class Edge{
    int v1;
    int v2;
    int cost;
    Edge(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}



