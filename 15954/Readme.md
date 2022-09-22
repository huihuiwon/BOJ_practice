문제에서 간과했던 점은 K개의 연속된 위치에 있는 인형들을 선택하는 것이 아니라</br>
**K개 이상** 을 선택하는 것

```
double result = Double.MAX_VALUE;
for(int i=0; i<=n-k; i++) {
  for(int t=k; t<=n-i; t++) {
    int sum = 0;
    for(int j=i; j<i+t; j++) {
      sum += doll[j];
    }
    double m = sum/(t*1.0);

    double tmp = 0;
    for(int j=i; j<i+t; j++) {
      tmp += Math.pow(doll[j]-m, 2);
    }

    tmp /= t;
    tmp = Math.sqrt(tmp);

    result = Math.min(result, tmp);
    System.out.println(result);
  }
}
```

코드는 위와 같다

변수 t를 이용해서 k개 이상을 뽑는 것을 표현</br>
여기서 `int sum=0;` 으로 갱신하는 위치를 for문으로 t를 돌리기 전에 넣었었는데,</br>
t를 돌릴 때마다 sum도 새로 구해줘야 하므로 `sum+=doll[j]` 하기 직전에 다시 초기화 해야 함

코드를 수정할 때 변수 초기화 위치를 잘 넣어주기
