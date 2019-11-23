import java.io.*;

public class QuickSort {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 0;
        try {
            size = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arr = new int[size];
        //int[] temp = new int[size];

        for (int i = 0; i < size; i++) {
            try {
                arr[i] = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        QuickSort(arr, 0, size-1);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int result : arr){
            try {
                bufferedWriter.write(result + "\n");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        try {
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void QuickSort(int[] arr, int start, int end){
        int left_cur = start;
        int righit_cur = end;
        int mid = (start+end)/2;
        int pivot = arr[mid];

        do{
            while (arr[left_cur] < pivot) left_cur++;
            while (arr[righit_cur] > pivot) righit_cur--;
            if (left_cur <= righit_cur){
                int temp = arr[left_cur];
                arr[left_cur] = arr[righit_cur];
                arr[righit_cur] = temp;
                left_cur++;
                righit_cur--;
            }
        }while (left_cur <= righit_cur);

        if (start <= righit_cur) QuickSort(arr, start, righit_cur);
        if (left_cur <= end) QuickSort(arr, left_cur, end);
    }
}
