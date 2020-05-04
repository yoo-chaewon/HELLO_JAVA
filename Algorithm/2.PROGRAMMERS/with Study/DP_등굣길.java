class Solution {
    static int DIV = 1000000007;
    public static int solution(int m, int n, int[][] puddles) {
        int [][] map = new int[n+1][m+1];
        for (int[] puddle : puddles){
            map[puddle[1]][puddle[0]] = -1;
        }

        map[1][1] = 1;
        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < m+1; j++){
                if (map[i][j] == -1)map[i][j] = 0;
                else {
                    if (i == 1){
                        map[i][j] += map[i][j-1] % DIV;
                    }else {
                        map[i][j] = (map[i-1][j] + map[i][j-1]) % DIV;
                    }
                }

            }
        }
        return map[n][m];
    }
}