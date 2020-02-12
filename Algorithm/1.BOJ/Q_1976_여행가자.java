import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[]parent;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        parent = new int[N+2];

        for (int i = 1; i < N+1; i++){
            parent[i] = i;
        }

        for (int i = 1; i < N+1; i++){
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 1; j < N+1; j++){
                if (Integer.parseInt(input[j-1]) == 1){
                    Merge(i, j);
                }
            }
        }

        String[] plan = bufferedReader.readLine().split(" ");
        for (int i = 0; i < M-1; i++){
            if (!check(Integer.parseInt(plan[i]), Integer.parseInt(plan[i+1]))){
                System.out.print("NO");
                return;
            }
        }
        System.out.print("YES");
    }
    public static void Merge(int a, int b){
        a = find(a);
        b = find(b);

        if (a <= b) parent[b] = a;
        else parent[a] = b;
    }

    public static int find(int a){
        if (a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }

    public static boolean check(int a, int b){
        a = find(a);
        b = find(b);

        if (a == b) return true;
        else return false;
    }
}
