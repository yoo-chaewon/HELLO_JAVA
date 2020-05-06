import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6, 6, new String[] {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    public static int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i <m; i++){
            for (int j = 0; j < n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }

        int answer = 0;
        while (true){
            boolean[][] changed = new boolean[m][n];
            boolean flag = false;
            for (int i = 0; i <= m-2; i++){
                for (int j = 0; j <= n-2; j++){
                    char cur = map[i][j];
                    if (cur == '*') continue;
                    if (checkFour(map, j, i, cur)){
                        for (int y = 0; y < 2; y++){
                            for (int x = 0; x < 2; x++){
                                changed[i+y][j+x] = true;
                                flag = true;
                            }
                        }
                    }
                }
            }

            if (!flag) break;
            for (int i = 0; i < n; i++){
                ArrayList<Character> arrayList = new ArrayList<>();
                for (int j = m-1; j >= 0; j--){
                    if (!changed[j][i]) {
                        arrayList.add(map[j][i]);
                    }else {
                        answer++;
                    }
                }

                int index = 0;
                for (int j = m-1; j >= 0; j--){
                    if (index >= arrayList.size()) map[j][i] ='*';
                    else map[j][i] = arrayList.get(index++);
                }

            }
        }
        return answer;
    }

    public static boolean checkFour(char[][] map, int x, int y, char cur){
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                if (cur != map[i+y][j+x]) return false;
            }
        }
        return true;
    }
}