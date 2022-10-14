시계방향으로 회전하면서 숫자가 바뀌는데,</br>
유효한 회전 (동일하지 않은 회전) 은 N/4-1번

즉 N이 12면 3회전부터는 동일한 숫자가 나오므로 할 필요가 없다</br>
이를 표현하기 위해 처음 for문은 `for(int a=0; a<n/4; a++)`

그리고 숫자는 무조건 4로 나뉘어진다</br>
즉 12면 123 456 789 101112</br>
(처음에 n/4를 했다가 틀렸음)

```
for(int a=0; a<div; a++) {
	for(int i=0; i<4; i++) {
		int sum = 0; int cur = div-1;
		for(int j=i*div; j<i*div+div; j++) {
      char c = sb.charAt(j); int index=0;
      if(!Character.isDigit(c)) index = c-'A'+10;
      else index = c-'0';
      sum += Math.pow(16, cur--)*(arr[index]);
    }
    hs.add(sum);
  }
  sb.insert(0, sb.charAt(n-1));
  sb.deleteCharAt(n);
}
```

핵심 코드는 위와 같다</br>
div, 즉 n/4번 숫자를 바꾸는데 이는 StringBuilder를 이용해서 표현</br>
`insert(0, 숫자)` 를 하고 `deleteCharAt(n)` 을 하면 제일 뒤의 숫자를 맨 앞으로 바꿀 수 있다</br>
이때 n-1이 아닌 n번째 숫자를 없애야 함</br>
왜냐면 기존 N개의 숫자에서 insert를 해서 N+1이 되었는데,</br>
지우고자 하는 문자는 제일 마지막 문자이므로

그리고 동일한 수가 중복으로 생성될 수 있으나 중복은 카운트 하지 않아야 하니</br>
Set을 이용</br>
이때 정렬을 해야 하니, TreeSet을 이용

TreeSet을 배열로 변환하기 위해서</br>
`hs.toArray(배열명)` 을 해서 배열로 변환
