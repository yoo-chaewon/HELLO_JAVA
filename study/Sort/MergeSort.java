import java.io.*;

public class MergeSort {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 0;
        try {
            size = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arr = new int[size];
        int[] temp = new int[size];

        for (int i = 0; i < size; i++) {
            try {
                arr[i] = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        MergeSort(arr, temp, 0, size-1);

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
    public static void MergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            MergeSort(arr, temp, start, mid);
            MergeSort(arr, temp, mid + 1, end);
            Merge(arr, temp, start, mid, end);
        }
    }

    public static void Merge(int[] arr, int[] temp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int left = start;
        int right = mid + 1;
        int temp_cur = start;
        while (left <= mid && right <= end) {
            if (temp[left] <= temp[right]) {
                arr[temp_cur] = temp[left];
                left++;
            } else {
                arr[temp_cur] = temp[right];
                right++;
            }
            temp_cur++;
        }
        for (int i = 0; i <= mid - left; i++) {//앞쪽배열 남아있을 경우
            arr[temp_cur + i] = temp[left + i];
        }
    }
}
