import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int testCase = scanner.nextInt();

        for (int t = 0; t < testCase; t++) {
            int n = scanner.nextInt(); //parking
            int m = scanner.nextInt(); //car
            int[] parkFee = new int[n + 1];
            int[] carFee = new int[m + 1];
            for (int i = 1; i <= n; i++) parkFee[i] = scanner.nextInt();
            for (int i = 1; i <= m; i++) carFee[i] = scanner.nextInt();

            int answer = 0;
            int[] park = new int[n+1];
            int times = m * 2;
            Queue<Integer> queue = new LinkedList<>();
            while (times-->0){
                int cur = scanner.nextInt();
                if (cur > 0){
                    boolean flag = true;
                    for (int i = 1; i <= n; i++){
                        if (park[i] == 0){
                            flag = false;
                            park[i] = cur;
                            answer += parkFee[i] * carFee[cur];
                            break;
                        }
                    }
                    if(flag) queue.add(cur);
                }else {
                    int empty = 0;
                    for (int i = 1; i <= n; i++){
                        if (park[i] == cur * -1){
                            park[i] = 0;
                            empty = i;
                        }
                    }
                    if (!queue.isEmpty()){
                        int curCar = queue.poll();
                        park[empty] = curCar;
                        answer += parkFee[empty] * carFee[curCar];
                    }
                }
            }
            System.out.println("#"+(t+1) + " " + answer);
        }
    }
}
