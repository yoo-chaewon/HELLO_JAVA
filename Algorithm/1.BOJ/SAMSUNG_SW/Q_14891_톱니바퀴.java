import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int size = 8;
    static int gearCount = 4;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        map = new int[gearCount][size];
        for (int i = 0; i < gearCount; i++) {
            String[] input = bufferedReader.readLine().split("");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int K = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < K; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int curGear = Integer.parseInt(input[0]) - 1;
            int dir = Integer.parseInt(input[1]);
            int curDir = dir;

            Queue<com.company.Rotation> queue = new LinkedList<>();
            queue.add(new com.company.Rotation(curGear, dir));
            for (int k = curGear; k < gearCount - 1; k++) {//front
                if (!rotationCheck(k, curDir, true)) {
                    curDir = 0 - curDir;
                    queue.add(new com.company.Rotation(k + 1, curDir));
                }else break;
            }

            curDir = dir;
            for (int j = curGear; j > 0; j--) {
                if (!rotationCheck(j, curDir, false)) {
                    curDir = 0 - curDir;
                    queue.add(new com.company.Rotation(j - 1, curDir));
                }else break;
            }

            while (!queue.isEmpty()) {
                com.company.Rotation curRotation = queue.poll();
                shiftGear(curRotation.gear, curRotation.dir);
            }
        }
        System.out.println(result());
    }

    public static boolean rotationCheck(int cur, int dir, boolean front) {
        if (front) {
            if (map[cur][2] != map[cur + 1][6]) return false;
        } else {
            if (map[cur - 1][2] != map[cur][6]) return false;
        }
        return true;
    }

    public static void shiftGear(int cur, int dir) {//dir:1-시계, 0-반시계
        if (dir == 1) {//시계
            int last = map[cur][size - 1];
            for (int i = size - 1; i > 0; i--) {
                map[cur][i] = map[cur][i - 1];
            }
            map[cur][0] = last;
        } else {
            int first = map[cur][0];
            for (int i = 0; i < size - 1; i++) {
                map[cur][i] = map[cur][i + 1];
            }
            map[cur][size - 1] = first;
        }
    }

    public static int result() {
        int answer = 0;
        for (int i = 0; i < gearCount; i++) {
            if (map[i][0] == 1) {
                answer += Math.pow(2, i);
            }
        }
        return answer;
    }
}

class Rotation {
    int gear;
    int dir;
    Rotation(int gear, int dir) {
        this.gear = gear;
        this.dir = dir;
    }
}