import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int MAX_SIZE = 2000001;
    static int[] parent;
    static int[] relation;
    static int[] level;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        parent = new int[MAX_SIZE];
        relation = new int[MAX_SIZE];
        level = new int[MAX_SIZE];

        for (int i = 1; i < MAX_SIZE; i++) {
            parent[i] = i;
            relation[i] = 1;
        }
        int index = 1;

        while (M-- > 0) {
            String[] input = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if (!hashMap.containsKey(a)) {
                hashMap.put(a, index++);
            }

            if (!hashMap.containsKey(b)) {
                hashMap.put(b, index++);
            }

            int aIndex = hashMap.get(a);
            int bIndex = hashMap.get(b);

            if (Integer.parseInt(input[0]) == 0) {
                Merge(aIndex, bIndex);
            } else {
                aIndex = findParent(aIndex);
                bIndex = findParent(bIndex);

                if (aIndex == bIndex) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static void Merge(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        parent[b] = a;
        relation[a] += relation[b];
        level[a]++;

        if (level[a] == level[b]) level[a]++;
    }

    public static int findParent(int u) {
        if (u == parent[u]) return u;
        else return parent[u] = findParent(parent[u]);
    }
}