## **정렬**

### #file name: sort1

#### 선택정렬(Select Sort)

첫 번째 자료를 두번째 자료부터 마지막 자료까지 차례대로 비교하여 가장 작은 값을 찾아 첫 번째에 놓고, 두 번째 자료를 세 번째 자료부터 마지막 자료까지와 차례대로 비교하여 그 중 가장 작은 값을 찾아 두 번째 위치에 놓는 과정을 반복하며 정렬을 수행한다. 1회전을 수행하고 나면 가장 작은 값의 자료가 맨 앞에 오게 되므로 그 다음 회전에서는 두 번째 자료를 갖고 비교한다.

```java
public int[] SelectSort(int count, int[] arr){
    int cur_x = 0;
    int cur_m = cur_x + 1;
    int temp;

    for (int i = 0; i < count; i++){
        for (int j = i+1 ; j < count; j++){
            if (arr[i] > arr[j]){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr;
}
```



#### 버블정렬(Bubble Sort)

첫 번째 자료와 두 번째 자료를, 두 번째 자료와 세 번째 자료를, 세 번째와 네 번째를,.. 이런 식으로 (마지막 -1)번째 자료와 마지막 자료를 비교하여 교환하면서 자료를 정렬한다. 1회전을 수행하고 나면 가장 큰 자료가 맨 뒤로 이동하고 2회전에서는 맨 끝네 있는 자료는 정렬에서 제외되고, 2회전을 수행하고 나면 끝에서 두 번째 자료까지는 정렬에서 제외된다. 이렇게 정렬을 1회전 수행할 때마다 정렬에서 제외되는 데이터가 하나씩 늘어난다. 

```java
public int[] BubbleSort(int count, int[] arr) {
    int temp;

    for (int i = 1; i < count; i++) {
        for (int j = 0; j < count - i; j++) {
            if (arr[j] > arr[j+1]) {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    return arr;
}
```



#### 삽입정렬(insert Sort)

두 번째 자료부터 시작하여 그 앞(왼쪽)의 자료들과 비교하여 삽입 할 위치를 지정한 후 자료를 뒤로 옮기고 지정한 자리에 자료를 삽입하여 정렬하는 알고리즘이다. 즉, 두 번째 자료는 첫 번째 자료, 세 번째 자료는 두 번째 자료와 첫 번째 자료, 네 번째 자료는 세 번째, 두 번째, 첫 번째 자료와 비료한 후 자료가 삽입 될 위치를 찾는다. 자료가 삽입될 위치를 찾았다면 그 위치에 자료를 삽입하기 위해 자료를 한 칸씩 뒤로 이동시킨다.

```java
public int[] InsertSort(int count, int[] arr){
    int key;
    for (int i = 1 ; i < count ; i++){
        key = arr[i];
        for (int j = i-1; j >= 0; j--){
            if (arr[j] > key){
                arr[j+1] = arr[j];
                arr[j] = key;
            }
            else break;
        }
    }
    return  arr;
}
```





### #file name: sort2

#### 병합정렬(merge Sort)

하나의 리스트를 두 개의 균등한 크기로 분할하고 분할된 부분 리스트를 정렬한 다음, 두 개의 정렬된 부분 리스트를 합하여 전체가 정렬된 리스트가 되게 하는 방법. 

병합 정렬은 분할, 정복, 결합의 단계로 이루어짐.

- 분할(Divide): 입력 배열은 같은 크기의 2개로 부분 배열로 분할한다.
- 정복(Conquer): 부분 배열을 정렬한다. 부분 배열의 크기가 충분히 작지 않으면 순환호출을 이용하여 다시 분할 정복 방법을 적용한다.
- 결합(Combine): 정렬된 부분 배열들을 하나의 배열에 합병한다.

병합 정렬의 과정

- 추가적인 리스트 필요 -> 공간 복잡도가 다른 정렬에 비해 많이 든다
- 각 부분 배열을 정렬할 때도 병합 정렬을 순환적으로 호출하여 적용
- 병합 정렬에서 실제로 정렬이 이루어지는 시점은 12개의 리스트를 merge하는 단계에서 일어남

```java
public void MergeSort(int[] arr, int[] temp, int start, int end) {
    if (start < end) {
        int mid = (start + end) / 2;
        MergeSort(arr, temp, start, mid);
        MergeSort(arr, temp, mid + 1, end);
        Merge(arr, temp, start, mid, end);
    }
}

public void Merge(int[] arr, int[] temp, int start, int mid, int end) {
    for (int i = start; i <= end; i++){
        temp[i] = arr[i];
    }
    int left = start;
    int right = mid+1;
    int temp_cur = start;
    while (left <= mid && right <= end){
        if (temp[left] <= temp[right]){
            arr[temp_cur] = temp[left];
            left++;
        }else{
            arr[temp_cur] = temp[right];
            right++;
        }
        temp_cur++;
    }
    for (int i = 0; i <= mid-left; i++){//앞쪽배열 남아있을 경우
        arr[temp_cur+i] = temp[left+i];
    }
}
```

#### 힙정렬(Heap Sort)

힙 정렬은 완전 이진 트리를 기본으로 하는 힙(Heap) 자료구조를 기반으로한 정렬 방식이다. 완전 이진 트리는 삽입할 때 왼쪽부터 차례대로 추가하는 이진 트리를 말한다. 힙에는 부모 노드의 값이 자식 노드의 값보다 항상 큰 최대 힙과 그 반대인 최소 힙이 존재한다.

#### 퀵정렬(Quick Sort)

분할 정복 알고리즘의 하나로, 평균적으로 매우 빠른 수행 속도를 자랑하는 정렬 방법이다. merge sort와 달리 퀵 정렬은 리스트를 비균등하게 분할한다. 

리스트 안에 있는 한 요소를 선택한다. 이렇게 고른 원소를 피벗(pivot)이라고 한다. 피봇을 기준으로 피봇보다 작은 요소들을 모두 피봇의 왼쪽으로 옮겨지고 피봇보다 큰 요소들은 모두 피봇의 오른쪽으로 옮겨진다.(즉, 피봇을 중심으로 왼쪽은 피봇보다 작은 요소들, 오른쪽은 피봇보다 큰 요소들)

피봇을 제외한 왼쪽 리스트와 오른쪽 리스트를 다시 정렬한다. 분할된 리스트에 대하여 순환 호출을 이용하여 정렬을 반복한다. 이렇게 부분 리스트에서도 다시 피벗을 정하고 피벗을 기준으로 2개의 부분 리스트로 나누는 과정을 반복한다.

#### 계수 정렬(Count Sort)

모든 숫자들의 개수를 센 후, 누적 합을 구하고, 다시 숫자를 넣어준다.

```java
public void CountSort(BufferedReader br, int size){
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int i = 0; i <size; i++){
        try {
            arr.add(Integer.parseInt(br.readLine()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    int max = arr.get(0);
    for (int i = 0; i <size; i++){
        if (arr.get(i) > max){
            max = arr.get(i);
        }
    }
    int[] index = new int[max+1];
    for (int i = 0; i < index.length; i++){
        index[i] = 0;
    }
    for (int i = 0; i < arr.size()  ; i++){
        int count = 0;
        if (index[arr.get(i)] == 0){
            count++;
            index[arr.get(i)] = count;
        }else {
            index[arr.get(i)] += 1;
        }
    }
    for (int i = 0; i < index.length-1; i++){
        index[i+1] += index[i];
    }
    int[] place = new int[arr.size()+1];
    for (int i = 0; i < arr.size(); i++){
        place[index[arr.get(i)] - 1 ] = arr.get(i);
        index[arr.get(i)]  -= 1;
    }
    for (int i = 0; i < place.length -1; i++) {
        System.out.println(place[i]);
    }
}
```

#### 기수 정렬(Radix Sort)









# 정렬 알고리즘 시간복잡도 비교

| Name     | Best  | Avg   | Worst |
| -------- | ----- | ----- | ----- |
| 삽입정렬 | n     | n^2   | n^2   |
| 선택정렬 | n^2   | n^2   | n^2   |
| 버블정렬 | n^2   | n^2   | n^2   |
| 퀵정렬   | nlogn | nlogn | n^2   |
| 힙정렬   | nlogn | nlogn | nlogn |
| 병합정렬 | nlogn | nlogn | nlogn |

- 단순하지만 비효율적인 방법

  : 삽입 정렬, 선택 정렬, 버블 정렬

- 복잡하지만 효율적인 방법

  : 퀵 정렬, 힙 정렬, 병합 정렬, 기수 정렬