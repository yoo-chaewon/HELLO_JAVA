import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main obj1 = new Main();
        //obj1.SortInSide();
        //obj1.WordSort();
        obj1.Statistics();
    }

    //1427
    public void SortInSide() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int size = input.length();
        char[] arr = new char[size];
        for (int i = 0; i < size; i++) {
            arr[i] = input.charAt(i);
        }
        BubbleSort(size, arr);
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
        }
    }

    public char[] BubbleSort(int size, char[] arr) {
        int temp;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = (char) temp;
                }
            }
        }
        return arr;
    }

    //1181
    public void WordSort() {
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

    //1181_2
    public void WordSort2() {
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

    public String[] SelectSort(String[] words, int[] count, int size) {
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

    //2108
    public void Statistics() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int size = 0;
        int sum = 0;//산술 평균
        try {
            size = Integer.parseInt(br.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < size; i++) {
            try {
                arr.add(Integer.parseInt(br.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //산술평균
        for (int i = 0; i < size; i++){
            sum += arr.get(i);
        }
        int avg = (int)Math.round(sum*1.0/size);
        System.out.println(avg);

        //중앙값
        Collections.sort(arr);
        int mid = (size-1) /2;
        System.out.println(arr.get(mid));

        //최빈값
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++){
            if (map.containsKey(arr.get(i))) {//키가 있으면
                map.put(arr.get(i), map.get(arr.get(i)).intValue() + 1);
            }
            else {//키가 없으면
                map.put(arr.get(i), 1);
            }
        }
        int max_value = map.get(arr.get(0)).intValue();
        for (int i = 0; i < map.size(); i++){
            if (map.get(arr.get(i).intValue()) > max_value){
                max_value = map.get(arr.get(i).intValue());
            }
        }

        ArrayList<Integer> min_arr = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> i: map.entrySet()){
            if (i.getValue() == max_value) {
                min_arr.add(i.getKey());
            }
        }
        //System.out.println(min_arr);
        Collections.sort(min_arr);
        if (min_arr.size() == 1){
            System.out.println(min_arr.get(0));
        }else{
            System.out.println(min_arr.get(1));
        }
        map.clear();
        //범위
        int min = arr.get(0);
        int max = arr.get(size-1);
        System.out.println(max-min);
    }
}
