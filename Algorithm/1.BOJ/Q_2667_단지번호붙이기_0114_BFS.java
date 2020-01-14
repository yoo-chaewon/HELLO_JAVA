import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int size;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++){
            String[] input = bufferedReader.readLine().split("");
            for (int j = 0; j <size; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int aptSet = 0;
        ArrayList<Integer> aptCount = new ArrayList<>();
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (map[i][j] != 0 && !visited[i][j]) {
                    aptSet++;
                    BFS(j, i);
                    aptCount.add(count);
                }
            }
        }
        System.out.println(aptSet);
        Collections.sort(aptCount);
        for (int a : aptCount){
            System.out.println(a);
        }
    }

    public static void BFS(int x, int y){
        Queue<com.company.Point> queue = new LinkedList<>();
        queue.add(new com.company.Point(x, y));
        visited[y][x] = true;
        count = 0;
        while (!queue.isEmpty()){
            com.company.Point cur = queue.poll();
            count++;
            for (int i = 0; i < 4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextY < 0 || size <= nextX || size <= nextY || visited[nextY][nextX] || map[nextY][nextX] == 0) continue;
                queue.add(new com.company.Point(nextX, nextY));
                visited[nextY][nextX] = true;
            }
        }
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