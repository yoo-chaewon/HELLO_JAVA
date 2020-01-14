import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

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
            for (int j = 0; j <size; j++){
                if (map[i][j] != 0 && !visited[i][j]){
                    aptSet++;
                    count = 0;
                    DFS(j, i);
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

    public static void DFS(int x, int y){
        count++;
        visited[y][x] = true;
        for (int i =0; i < 4; i++){
            int curX = x + dx[i];
            int curY = y + dy[i];

            if (curX < 0 || size <= curX || curY < 0 || size <= curY || visited[curY][curX] || map[curY][curX] == 0) continue;
            DFS(curX, curY);
        }
    }
}