import java.util.Scanner;

public class WordSort2 {
    public static void main(String[] args){
        WordSort2();
    }
    //1181_2
    public static void WordSort2() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String[] words = new String[size];
        int[] count = new int[size];
        for (int i = 0; i < size; i++) {
            words[i] = scanner.next();
            count[i] = words[i].length();
        }
        words = SelectSort(words, count, size);
        for (int i = 0; i < size; i++) {
            System.out.println(words[i]);
        }
    }

    public static String[] SelectSort(String[] words, int[] count, int size) {
        int i_temp;
        String s_temp;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (count[i] > count[j]) {
                    i_temp = count[i];
                    count[i] = count[j];
                    count[j] = i_temp;

                    s_temp = words[i];
                    words[i] = words[j];
                    words[j] = s_temp;
                }
            }
        }
        return words;
    }
}
