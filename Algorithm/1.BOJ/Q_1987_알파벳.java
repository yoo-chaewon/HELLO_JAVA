import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static int R;
    static int C;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = Integer.MIN_VALUE;
    static char[][] map;


    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = bufferedReader.readLine().split(" ");

        R = Integer.parseInt(RC[0]); //세로
        C = Integer.parseInt(RC[1]); //가
        map = new char[R][C];
        visited = new boolean[R][C];
        HashSet<Character> hashSet = new HashSet<>();


        for (int i = 0; i < R; i++){
            String input = bufferedReader.readLine();
            for (int j = 0; j < C; j++){
                map[i][j] = input.charAt(j);
            }
        }

        visited[0][0] = true;
        hashSet.add(map[0][0]);
        DFS(hashSet,0, 0);

        System.out.println(Math.max(result, hashSet.size()));

    }

    public static void DFS(HashSet<Character> hashSet, int x, int y) {
        for (int i = 0; i < 4; i++){
            int curX = x + dx[i];
            int curY = y + dy[i];

            if (curX >= 0 && curY >= 0 && curX < C && curY < R && !visited[curY][curX] && !hashSet.contains(map[curY][curX])){
                visited[curY][curX] = true;
                hashSet.add(map[curY][curX]);
                result = Math.max(result, hashSet.size());
                DFS(hashSet, curX, curY);
                visited[curY][curX] = false;
                hashSet.remove(map[curY][curX]);
            }
        }
    }
}


