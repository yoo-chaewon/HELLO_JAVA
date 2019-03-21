import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main obj = new Main();
        //obj.gameMain();
    }
    //1103
    static char[][]map;
    static int[][] count;
    static int N, M;
    public void gameMain(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        String[] str = new String[N];
        for (int i = 0 ; i < N; i++){
            str[i] = sc.next();
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = str[i].charAt(j);
            }
        }
        count = new int[N][M];
        game(0,0);
        int result = 0;
        int temp = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (count[i][j] > result){
                    result = count[i][j];
                }
            }
        }
        System.out.println(result);
    }
    static int result = 0;
    public void game(int x, int y){
        if ((x < 0 || M-1 < x || y < 0 || N-1 < y)){//박스 밖
            return;
        }else {//그 자리에서 재귀를 불러야 하는 것.
            int number = (int)map[y][x]-48;//char을 int로
            result++;
            count[y][x] = result;
            game(y+number, x);
            game(y, x+number);
            game(y-number, x);
            game(y, x-number);

        }
    }

    //1039
    public void ExchangeMain(){

    }
    public void Exchange(){

    }
}
