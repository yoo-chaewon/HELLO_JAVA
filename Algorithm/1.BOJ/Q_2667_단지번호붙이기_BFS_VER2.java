import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[][] visited;
    static int size;
    static Queue<com.company.Point> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0,0,-1,1};
    static ArrayList<Integer> answer = new ArrayList<>();
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = bufferedReader.readLine().split("");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int apt = 0;

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (map[i][j] != 0 && !visited[i][j]){
                    BFS(j , i);
                    apt++;
                }
            }
        }

        System.out.println(apt);
        Collections.sort(answer);
        for (int a: answer){
            System.out.println(a);
        }


    }
    public static void BFS(int x, int y){
        int temp = 1;

        visited[y][x] = true;
        queue.add(new com.company.Point(x, y));
        while (!queue.isEmpty()){
            com.company.Point cur = queue.poll();

            for (int i = 0; i < 4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (size <= nextX || size <= nextY || nextX < 0 || nextY < 0 || visited[nextY][nextX] || map[nextY][nextX] == 0)continue;
                queue.add(new com.company.Point(nextX, nextY));
                visited[nextY][nextX] = true;
                temp++;
            }
        }
        answer.add(temp);
    }
}
class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}


