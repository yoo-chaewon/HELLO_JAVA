import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int MAX_SIZE = 200001;
    static int index = 1;
    static int[] parent;
    static int[] level;
    static int[] relation;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());

        while (testCase-- > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            int f = Integer.parseInt(bufferedReader.readLine());
            HashMap<String, Integer> hash = new HashMap<>();
            parent = new int[MAX_SIZE];
            level = new int[MAX_SIZE];
            relation = new int[MAX_SIZE];

            for (int i = 1; i < MAX_SIZE; i++) {
                parent[i] = i;
                relation[i] = 1;
            }

            while (f-- > 0) {
                String[] input = bufferedReader.readLine().split(" ");
                String a = input[0];
                String b = input[1];

                if (!hash.containsKey(a)){
                    hash.put(a, index++);
                }

                if (!hash.containsKey(b)){
                    hash.put(b, index++);
                }
                int aIndex = hash.get(a);
                int bIndex = hash.get(b);

                Merge(aIndex, bIndex);
            }
        }
    }

    public static void Merge(int a, int b){
        a = find(a);
        b = find(b);

        if (a == b){
            System.out.println(relation[a]);
            return;
        }

        //b가 더 높다고 가정
        if (level[a] > level[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }

        parent[a] = b;
        relation[b] += relation[a];
        System.out.println(relation[b]);

        if (level[a] == level[b]){
            level[b]++;
        }
    }

    //parent node 찾는 메소드
    public static int find(int u){
        if (u == parent[u]){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
}