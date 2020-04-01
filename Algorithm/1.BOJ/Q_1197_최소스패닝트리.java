import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] VE = bufferedReader.readLine().split(" ");
        int V = Integer.parseInt(VE[0]);
        int E = Integer.parseInt(VE[1]);
        parent = new int[V+1];
        for (int i = 1; i <= V; i++ ) parent[i] = i;

        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost-o2.cost;
            }
        });

        while (E-- > 0 ) {
            String[] input = bufferedReader.readLine().split(" ");
            queue.add(new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }

        int sum = 0;
        while (!queue.isEmpty()){
            Edge cur = queue.poll();
            if (!isSameParent(cur.v1, cur.v2)){
                sum += cur.cost;
                union(cur.v1, cur.v2);
            }
        }
        System.out.println(sum);
    }

    public static void union(int x, int y){
        x = findParent(x);
        y = findParent(y);

        if (x != y){
            parent[y] = x;
        }
    }

    public static int findParent(int x){
        if (x == parent[x]) return x;
        else return findParent(parent[x]);
    }

    public static boolean isSameParent(int x, int y){
        if (findParent(x) == findParent(y)) return true;
        else return false;
    }
}

class Edge  {
    int v1;
    int v2;
    int cost;
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}



