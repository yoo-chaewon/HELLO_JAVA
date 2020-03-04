public class Main {
    public static void main(String[] args) {
        int[][] delivery = {{1, 5}, {8, 3}, {4, 2}, {2, 3}, {3, 1}, {3, 2}, {4, 2}, {5, 2}, {4, 1}};
        int[][] deliver2 = {{1, 10}, {8, 1}, {8, 1}, {3, 100}, {8, 1}, {8, 1}, {8, 1}, {8, 1}, {8, 1},
                {8, 1}, {8, 1}, {8, 1}, {9, 100}, {8, 1}, {8, 1}, {8, 1}};

        System.out.println(Solution.solution(3, delivery));
        System.out.println(Solution.solution(4, deliver2));
    }
}

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int limit = 0;
    static int size;
    static int result = 0;

    public static int solution(int r, int[][] delivery) {
        size = r;
        Home[][] map = new Home[r][r];
        for (int i = 0; i < delivery.length; i++) limit = Math.max(limit, delivery[i][0]);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                map[i][j] = new Home(delivery[i * size + j][0], delivery[i * size + j][1], false);
            }
        }
//        PrintMap(map);

        if (map[0][0].time > 0){
            DFS(0, 0, 1, map[0][0].tip, map);
        }else {
            DFS(0, 0, 1, 0, map);
        }
        return result;
    }

    public static void DFS(int x, int y, int time, int tip, Home[][] map) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size || time > limit) {
                result = Math.max(result, tip);
                continue;
            }

            if (time <= map[nextY][nextX].time && !map[nextY][nextX].visited) {
                map[nextY][nextX].visited = true;
                DFS(nextX, nextY, time + 1, tip + map[nextY][nextX].tip, map);
                map[nextY][nextX].visited = false;
            } else {
                DFS(nextX, nextY, time + 1, tip, map);
            }
        }
    }

    public static void PrintMap(Home[][] map) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("(" + map[i][j].time + "," + map[i][j].tip + ")");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Home {
    int time;
    int tip;
    boolean visited;

    Home(int time, int tip, boolean visited) {
        this.time = time;
        this.tip = tip;
        this.visited = visited;
    }
}


