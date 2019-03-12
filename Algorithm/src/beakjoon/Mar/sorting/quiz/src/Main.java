import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main obj1 = new Main();
        //obj1.SortInSide();
        obj1.WordSort();
    }

    //1427
    public void SortInSide(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int size = input.length();
        char[] arr = new char[size];
        for (int i = 0; i < size; i++) {
            arr[i] = input.charAt(i);
        }
        BubbleSort(size, arr);
        for (int i = 0; i <size; i++){
            System.out.print(arr[i]);
        }
    }

    public char[] BubbleSort(int size, char[] arr){
        int temp;
        for (int i = 1; i < size; i++){
            for (int j = 0; j < size-i; j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = (char)temp;
                }
            }
        }
        return arr;
    }

    //1181
    public void WordSort(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 0;
        try {
            size = Integer.parseInt(br.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }

        HashSet<String> words = new HashSet<String>();//for 중복X
        for (int i = 0; i < size; i++){
            try {
                words.add(br.readLine());
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        ArrayList<String> list = new ArrayList<String>(words);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                else if(o1.length() < o2.length())
                    return -1;
                else
                    return o1.compareTo(o2);
            }
        });

        for (String s:list)
            System.out.println(s);
    }

    //1181_2
    public void WordSort2(){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String[] words = new String[size];
        int[] count = new int[size];
        for (int i = 0; i < size; i++){
            words[i] = scanner.next();
            count[i] = words[i].length();
        }
        words = SelectSort(words, count, size);
        for (int i = 0; i < size; i++){
            System.out.println(words[i]);
        }
    }

    public String[] SelectSort(String[] words, int[] count, int size){
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
