import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static ArrayList<Point> stores;
    static ArrayList<Point> homes;
    static Stack<Point> selected;
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(input.nextToken());
        M = Integer.parseInt(input.nextToken());
        stores = new ArrayList<>();
        homes = new ArrayList<>();
        selected = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(str.nextToken());
                if (num == 1){
                    homes.add(new Point(j, i));
                }else if (num == 2){
                    stores.add(new Point(j, i));
                }
            }
        }
        Combination(0, 0);
        System.out.println(minDistance);
    }

    public static void Combination(int start, int depth) {
        if (depth == M) {
            minDistance = Math.min(minDistance, FindBest());
            return;
        }

        for (int i = start; i < stores.size(); i++) {
            selected.push(stores.get(i));
            Combination(i + 1, depth + 1);
            selected.pop();
        }
    }

    public static int FindBest() {
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (Point home: homes){
            for (Point store: selected){
                int distance = Math.abs(home.y - store.y) + Math.abs(home.x - store.x);
                min = Math.min(min, distance);
            }
            result+=min;
            min = Integer.MAX_VALUE;
        }

        return result;
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
