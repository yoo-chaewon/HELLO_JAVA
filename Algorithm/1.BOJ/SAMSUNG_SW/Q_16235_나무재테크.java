import java.util.*;

public class Main {
    static int N;
    static int[][] addMap;
    static int[][] groundMap;

    static Queue<Point> save = new LinkedList<>();
    static Queue<Point> death = new LinkedList<>();
    static PriorityQueue<Point> treeQueue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        addMap = new int[N][N];
        groundMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                addMap[i][j] = sc.nextInt();
                groundMap[i][j] = 5;
            }
        }

        treeQueue = new PriorityQueue<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.age - o2.age;
            }
        });

        for (int i = 0; i < M; i++) {
            treeQueue.add(new Point(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()));
        }

        for (int i = 0; i < K; i++) year();
        System.out.println(treeQueue.size());
    }

    static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};

    private static void year() {
        //봄
        while (!treeQueue.isEmpty()) {
            Point cur = treeQueue.poll();
            if (groundMap[cur.x][cur.y] >= cur.age) {
                groundMap[cur.x][cur.y] -= cur.age;
                cur.age += 1;
                save.add(cur);
            } else {
                death.add(cur);
            }
        }

        //여름
        while (!death.isEmpty()) {
            Point cur = death.poll();
            groundMap[cur.x][cur.y] += cur.age / 2;
        }

        //가을
        while (!save.isEmpty()) {
            Point cur = save.poll();
            if (cur.age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nextX = cur.x + dx[i];
                    int nextY = cur.y + dy[i];
                    if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                    treeQueue.add(new Point(nextX, nextY, 1));

                }
            }
            treeQueue.add(cur);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                groundMap[i][j] += addMap[i][j];
            }
        }
    }
}

class Point {
    int x, y, age;

    Point(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }
}