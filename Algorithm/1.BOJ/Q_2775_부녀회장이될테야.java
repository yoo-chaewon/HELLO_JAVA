import java.util.Scanner;

public class Apartment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] apt = new int[15][15];
        int[] k = new int[t];
        int[] n = new int[t];

        for (int z = 0 ; z < t; z++) {
            k[z] = sc.nextInt();//kÃþ
            n[z] = sc.nextInt();//nÈ£
            for (int i = 0; i < 15; i++) {
                apt[i][1] = 1;
            }
            for (int i = 2; i < 15; i++) {
                apt[0][i] = i;
            }
            for (int j = 1; j < 15; j++) {
                for (int i = 2; i < 15; i++) {
                    apt[j][i] = apt[j][i - 1] + apt[j - 1][i];
                }
            }
        }
        for (int z = 0 ; z < t; z++) {
            System.out.println(apt[k[z]][n[z]]);
        }
    }
}
