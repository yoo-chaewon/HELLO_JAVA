import java.util.Arrays;

class Solution {
    public static int[] parent;
    public static int[] level;
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        level = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        Arrays.sort(costs, ((o1, o2) -> Integer.compare(o1[2],o2[2])));

        for (int i = 0; i < costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];

            if (findParent(a) != findParent(b)){
                answer += costs[i][2];
                Merge(a, b);
            }
        }
        return answer;
    }

    public static void Merge(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if (a == b) return;
        if (level[a] < level[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }
        parent[b] = a;
        if (level[a] == level[b]) level[a]++;
    }

    public static int findParent(int a){
        if (parent[a] == a) return a;
        return parent[a] = findParent(parent[a]);
    }
}
