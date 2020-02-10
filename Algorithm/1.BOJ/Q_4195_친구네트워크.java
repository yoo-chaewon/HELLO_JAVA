import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int MAX_SIZE = 200001;
    static int[] parent;
    static int[] relation;
    static int[] level;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            int f = Integer.parseInt(bufferedReader.readLine());
            parent = new int[MAX_SIZE];
            relation = new int[MAX_SIZE];
            level = new int[MAX_SIZE];
            HashMap<String, Integer> hash = new HashMap<>();
            int index = 1;
            for (int i = 1; i < MAX_SIZE; i++){
                parent[i] = i;
                relation[i] = 1;
            }

            for (int i = 0; i < f; i++){
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
                merge(aIndex, bIndex);
            }
        }
    }

    public static void merge(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if (a == b){
            System.out.println(relation[a]);
            return;
        }

        //a 가 더 높아야 한다고 가정.
        if (level[a] < level[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }
        parent[b] = a;
        relation[a] += relation[b];
        level[a]++;
        System.out.println(relation[a]);

        if (level[a] == level[b]){
            level[a]++;
        }
    }

    public static int findParent(int a){
        if (a == parent[a]){
            return a;
        }
        return parent[a] = findParent(parent[a]);
    }
}