## 구현
L의 최댓값을 구하고, H의 최댓값과 H가 최댓값일 때 L을 구해야 한다</br>
이를 각각 mx, my, my_i 라 칭한다</br></br>

가장 큰 직사각형에서 빈 사각형을 빼는 방법이나</br>
사각형을 더해가는 방식이 있지만,</br>
여기서 기둥의 폭은 모두 1m 인 것을 이용하여 각 기둥의 면적을 더해가는 식으로 구하는 것이 가장 쉽다</br></br>

구해놓은 my_i 를 기준으로 왼쪽은 L의 오름차순으로 보면서</br>
현재까지 중에 가장 높은 기둥이 면적이 된다</br></br>

오른쪽은 L의 내림차순으로 보면서 현재까지 중에 가장 높은 기둥이 면적</br>

코드로 구현하면 다음과 같다</br>
```
for(int i=0; i<=my_i; i++) {
	cur=Math.max(cur, arr[i]);
	ans += cur;
}
cur=0;
for(int i=mx; i>my_i; i--) {
	cur=Math.max(cur, arr[i]);
	ans += cur;
}
```

`Math.max()` 함수를 이용하여 현재까지 기둥 중에 가장 높은 것을 구하는데</br>
폭이 1m이므로 `ans+=cur`만 하면 된다

다시 `cur=0` 으로 초기화하고 이번에는 L의 내림차순으로 훑어보면서 cur의 최댓값을 구하고</br>
ans에 더해주면 된다
