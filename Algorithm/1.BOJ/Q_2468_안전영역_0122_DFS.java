import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int size;
    static int maxArea = Integer.MIN_VALUE;
    static int[][] copy;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());
        int top = 1;
        int[][] map = new int[size][size];

        for (int i = 0; i < size; i++){
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < size; j++){
                map[i][j] = Integer.parseInt(input[j]);
                top = Math.max(Integer.parseInt(input[j]), top);
            }
        }

        for (int t = top; t >= 0 ; t--){
            int count = 0;
            copy = new int[size][size];
            visited = new boolean[size][size];
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                    if (map[i][j] >= t){//잠기면 0 안잠기면 1
                        copy[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                    if (copy[i][j] == 1 && !visited[i][j]){
                        count++;
                        DFS(j ,i);
                    }
                }
            }
            maxArea = Math.max(count, maxArea);
        }
        System.out.println(maxArea);
    }

    public static void DFS(int x, int y){
        visited[y][x] = true;

        for (int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size || visited[nextY][nextX] || copy[nextY][nextX] == 0) continue;
            DFS(nextX, nextY);
        }
    }
}
