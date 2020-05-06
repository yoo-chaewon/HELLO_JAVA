class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},
                new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int[][] paddingLock = paddingRock(lock, key.length);
        for (int d = 0; d < 4; d++) {
            key = Rotation(key);

            for (int i = 0; i <= paddingLock.length - key.length ; i++) {
                for (int j = 0; j <= paddingLock.length-key.length; j++){
                    if (Check(i, j, paddingLock, key)) return true;
                }
            }
        }
        return answer;
    }

    public static boolean Check(int x, int y, int[][] lock, int[][] key) {
        int[][] map = new int[lock.length][lock.length];
        for (int i = 0; i < lock.length; i++){
            for (int j = 0; j < lock.length; j++){
                map[i][j] = lock[i][j];
            }
        }

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                map[i+y][j+x] = (key[i][j] + map[i+y][j+x]);
            }
        }

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (map[key.length-1+i][key.length-1+j] != 1) return false;
            }
        }

        return true;
    }

    public static int[][] paddingRock(int[][] lock, int keySize) {
        int size = lock.length + (keySize - 1) * 2;
        int[][] map = new int[size][size];

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                map[keySize - 1 + i][keySize - 1 + j] = lock[i][j];
            }
        }
        return map;
    }

    public static int[][] Rotation(int[][] key) {
        int size = key.length;
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = key[size - 1 - j][i];
            }
        }
        return map;
    }
}