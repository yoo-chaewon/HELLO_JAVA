import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    static int N;
    static int[] dx = {0, 1, 0, -1}; // 북 , 동 , 남 , 서
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static int curDir = 1; // 동쪽 시작
    static int time = 0;
    static LinkedList<Point> snake;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine()); // 보드 크기
        int K = Integer.parseInt(bufferedReader.readLine()); // 사과 갯수
        map = new int[N][N];
        map[0][0] = 1;// 뱀 위치
        HashMap<Integer, String> snakeMove = new HashMap<>();

        for (int i = 0; i < K; i++) {
            String[] apple = bufferedReader.readLine().split(" ");
            map[Integer.parseInt(apple[0]) - 1][Integer.parseInt(apple[1]) - 1] = 4; // 사과 위치
        }

        snake = new LinkedList<>();
        snake.add(new Point(0, 0));
        int L = Integer.parseInt(bufferedReader.readLine()); // 뱀의 방향 변환 횟수
        for (int i = 0; i < L; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            snakeMove.put(Integer.parseInt(input[0]), input[1]);
        }

        while (true) {
            time++;
            Point head = snake.peekLast();
            int nextX = head.x + dx[curDir];
            int nextY = head.y + dy[curDir];
            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || map[nextY][nextX] == 1) break;

            if (map[nextY][nextX] != 4) {//사과
                Point tail = snake.poll();
                map[tail.y][tail.x] = 0;
            }
            map[nextY][nextX] = 1;
            snake.addLast(new Point(nextX, nextY));
            if (snakeMove.containsKey(time)) {
                if (snakeMove.get(time).equals("D")) curDir = (curDir + 1) % 4;
                else curDir = (curDir + 3) % 4;
            }
        }
        System.out.print(time);
    }
}

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
