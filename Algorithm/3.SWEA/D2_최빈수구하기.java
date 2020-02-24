import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int T = scanner.nextInt();
        while (T-- > 0){
            int testNum = scanner.nextInt();
            int[] scores = new int[102];
            for (int i = 0; i < 1000; i++){
                int score = scanner.nextInt();
                scores[score] ++;
            }

            int maxCount = 0;
            int maxScore = 0;
            for (int i = 0; i < 102; i++){
                if (maxCount <= scores[i]){
                    maxScore = i;
                    maxCount = scores[i];

                }
            }
            System.out.println("#" + testNum + " " + maxScore);
        }
    }
}
