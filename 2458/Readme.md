나보다 키가 작은 사람의 수와 키가 큰 사람의 수를 더 했을 때 N-1 이라면?</br>
나와 관계된 모든 사람과의 키 순서를 안다는 뜻

키 순서를 아는지 모르는지 나타내기 위해 인접리스트 사용

```
public static void DFS(int start) {
	chk[start] = true;
	for(int v : list.get(start)) {
		if(chk[v]) continue;
		cnt++;
		chk[v]=true;
		DFS(v);
	}
}
```

기존의 깊이를 알기 위한 DFS 함수 코드를 그대로 사용</br>
이때 역방향의 경우를 알기 위해서 list를 두 개 선언해서</br>
하나는 `list.get(a).add(b)` 하나는 `list2.get(b).add(a)` 를 한다

DFS 함수 역시 두 개를 써야하는데,</br>
이때 처음 실수했던 부분은 reverse_DFS() 함수 안에 재귀를 위한 함수로 DFS() 함수를 넣어버린 것</br>
복사 붙여넣기를 해서 거의 유사한 코드를 짤 때 제대로 변수를 고쳤는지 확인해야 함

</br>
플로이드-워셜로도 풀 수 있다!
