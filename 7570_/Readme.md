숫자가 주어졌을 때, 위치가 고정된 값은 연속되게 증가하는 수열</br>
즉 `5 2 4 1 3`이 주어졌다면, 연속되게 증가하는 `2 3`만이 고정된 값</br></br>

연속적인 증가하는 수열을 구하는 방법은 다음과 같다</br>
```
for(int i=1; i<=n; i++) {
  int k=sc.nextInt();
  dp[k]=dp[k-1]+1;
  max=Math.max(dp[k], max);
}
```
만약 `dp[k-1]`이 0이라면, 즉 직전 값이 아직 나오지 않았다면 1</br>
0이 아니라면 `dp[k-1]+1` 로 연속된 수열의 길이를 더 늘려주어야 한다</br></br>

max는 연속적으로 증가하는 수열의 최대 길이</br>
이때 max값은 고정된 값이니, n-max가 움직여야하는 횟수
