import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int L;
    static int C;
    static char[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] LC = bufferedReader.readLine().split(" ");
        L = Integer.parseInt(LC[0]);
        C = Integer.parseInt(LC[1]);

        map = new char[C];
        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            map[i] = input[i].charAt(0);
        }

        Arrays.sort(map);
        boolean[] visited = new boolean[C];
        DFS(0, 0, 0, 0, "");
    }

    public static void DFS(int start, int depth, int ja, int mo, String result) {
        if (depth == L) {
            if (mo >= 1 && ja >= 2) {
                System.out.println(result);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            char cur = map[i];
            switch (cur) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    DFS(i + 1, depth + 1, ja, mo + 1, result + map[i]);
                    break;
                default:
                    DFS(i + 1, depth + 1, ja + 1, mo, result + map[i]);
                    break;
            }
        }
    }
}