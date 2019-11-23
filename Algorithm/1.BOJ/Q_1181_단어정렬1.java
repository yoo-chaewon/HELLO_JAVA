import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class WordSort {
    public static void main(String[] args) {
        WordSort();
    }
    //1181
    public static void WordSort() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 0;
        try {
            size = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashSet<String> words = new HashSet<String>();//for 중복X
        for (int i = 0; i < size; i++) {
            try {
                words.add(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<String> list = new ArrayList<String>(words);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        for (String s : list) {
            System.out.println(s);
        }
    }
}
