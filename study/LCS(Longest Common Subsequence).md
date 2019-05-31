## LCS(Longest Common Subsequence)

LCS(Longest Common Subsequence)는 다이나믹 프로그래밍을 이용한 알고리즘 문제 풀이에 자주 이용된다.

이는 문자열 두개를 비교하여 순서대로 있는 가장 긴 문자의 수를 세는 것 이다.

```
Longest Common Substring VS Longest Common Subsequence
전자는 공통 부분 문자열, 후자는 공통 부분 수열
ABCDHEF
BCDEF
가 있을 경우
substring은 BCD(최장 길이 :3)
subsequence는 BCDEF(최장 길이: 5)
가 된다.
즉, subsequence는 연속적이지 않은 부분 문자열이다.
```



### LCS의 길이 구하기

DP로 특정 범위까지 값을 구하고 다른 범위까지의 값을 구할 때 이전에 구해 둔 값을 이용하여 효율적으로 문제를 해결한다.

```
배열을 만들어서 문자가 일치할 때는 좌측 상단의 값에 +1를 하여주고, 일치하지 않으면 좌측 또는 상단의 값 중 더 큰값을 선택하여 준다. 이를 끝까지 반복하여 나오는 가장 큰 수가 LCS가 된다.
```

![1559296550899](C:\Users\yoo\AppData\Roaming\Typora\typora-user-images\1559296550899.png)

![1559296566230](C:\Users\yoo\AppData\Roaming\Typora\typora-user-images\1559296566230.png)

![1559296580708](C:\Users\yoo\AppData\Roaming\Typora\typora-user-images\1559296580708.png)

- 같은 문자가 나오면 이전에 누적했던 LCS의 길이에 +1
- 비교한 문자가 다르면 비교한 문자가 포함되어 있는 직전 LCS값

# BOJ 9251

![1559296776707](C:\Users\yoo\AppData\Roaming\Typora\typora-user-images\1559296776707.png)