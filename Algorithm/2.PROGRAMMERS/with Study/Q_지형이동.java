import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}}, 3));
//        System.out.println(solution(new int[][]{{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}}, 1));
    }

    static int[][] group;
    static int groupCount = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] parent;
    public static int solution(int[][] land, int height) {
        group = new int[land.length][land.length];

        // Make Group
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (group[i][j] == 0) {
                    groupCount++;
                    group[i][j] = groupCount;
                    makeGroup(height, land, j, i);
                }
            }
        }

//        Print();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        parent = new int[groupCount + 1];
        for (int i = 1; i <= groupCount; i++) parent[i] = i;
        //Make Tree
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land.length; j++) {
                for (int k = 0; k < 4; k++) {
                    int nextX = j + dx[k];
                    int nextY = i + dy[k];
                    if (nextX < 0 || nextX >= land.length || nextY < 0 || nextY >= land.length) continue;
                    if (group[i][j] != group[nextY][nextX]) {
                        priorityQueue.add(new Edge(new Dot(j, i, land[i][j]), new Dot(nextX, nextY, land[nextY][nextX])));
                    }
                }
            }
        }

        int sum = 0;
        while (!priorityQueue.isEmpty()) {
            Edge cur = priorityQueue.poll();
            if (!isParent(group[cur.v1.y][cur.v1.x], group[cur.v2.y][cur.v2.x])) {
                sum += cur.cost;
                Union(group[cur.v1.y][cur.v1.x], group[cur.v2.y][cur.v2.x]);
            }
        }
        return sum;
    }

    public static void Union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b){
            parent[b] = a;
        }else {
            parent[a] = b;
        }
    }

    public static boolean isParent(int a, int b) {
        if (findParent(a) == findParent(b)) return true;
        else return false;
    }

    public static int findParent(int a) {
        if (a == parent[a]) return a;
        else return findParent(parent[a]);
    }

    public static void makeGroup(int height, int[][] land, int x, int y) {
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(x, y, land[y][x]));

        while (!queue.isEmpty()) {
            Dot cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                if (nextX < 0 || nextX >= land.length || nextY < 0 || nextY >= land.length
                        || group[nextY][nextX] != 0 || Math.abs(cur.value - land[nextY][nextX]) > height)
                    continue;
                group[nextY][nextX] = groupCount;
                queue.add(new Dot(nextX, nextY, land[nextY][nextX]));
            }
        }
    }

    public static void Print() {
        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j < group.length; j++) {
                System.out.print(group[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Dot {
    int x, y, value;
    Dot(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

class Edge {
    Dot v1, v2;
    int cost;

    Edge(Dot v1, Dot v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = Math.abs(v1.value - v2.value);
    }
}