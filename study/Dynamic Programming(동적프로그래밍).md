## Dynamic Programming(동적프로그래밍)

재귀의 단점: 함수를 연속적으로 불러야함 -> 오버헤드가 많이 생김

이를 해결하기 위해 동적 계획법

#### ***"다이나믹 프로그래밍이란 하나의 문제를 단 한번만 풀도록 하는 알고리즘"*******



### 동적 계획법

동적 계획법은 이전에 구한 답을 다시 가져오는 방법을 말한다.

반복적으로 메소드를 불러오는 횟수를 줄이고 추가 공간에 과거에 구한 답을 저장하여 그보다 큰 답이 무엇인지를 구한다. 이런 점에서 동적 계획법은 분할 정복 알고리즘과 매우 유사하다. 

즉, 동적계획법은 주어진 문제를 여러 하위 문제로 나눠서 푸는 것.

```
다이나믹 프로그래밍은 다음의 가정 하에 사용할 수 있다.
- 큰 문제를 작은 문제로 나눌 수 있을 때
- 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일한 경우
```

크고 어려운 문제가 있으면 그것을 먼저 잘게 나누어서 해결한 뒤에 처리하여 나중에 전체의 답을 구하는 것. 다만 이 과정에서 '메모이제이션(Memoization)'이 사용된다는 점에서 분활정복과 다르다. 이미 계산한 결과는 배열에 저장함으로써 나중에 동일한 계산을 할 때는 저장된 값을 단순히 반환하기만 하면 된다.



#### 예1 ) 피보나치 수열

```java
//DFS
public int DFS(int x){
    if(x==1) return 1;
    if(x==2) return 1;
    return DFS(x-1) + DFS(x-2);
}
```

DFS(50)일 경우 2의 50제곱의 계산이 됨.



```java
public int DP(int x){
    if(x==1) return 1;
    if(x==2) return 1;
    if(d[x] != 0) return d[x];
    return d[x] = DP(x-1) + DP(x-2);
}
```

이 경우 이미 계산된 결과는 배열 d에 저장되기 때문에 한 번 구한 값을 다시 구하는 일은 존재하지 않음. 