인접리스트와 DFS를 구현해서 깊이를 알아내는 문제

A-B-C-D-E 같이 깊이가 5 이상이면 1을 출력 아니면 0 출력

단순 DFS

```
public static void DFS(int start, int L) {
	if(L == 5) {
		flag = true;
		return;
	}
	
	chk[start] = true;
	for(int v : list.get(start)) {
		if(!chk[v]) {
			DFS(v, L+1);
		}
	}
}
```

를 돌리게 되면 최단 거리를 찾으려고 하지, 모든 노드를 거치려고 하지 않는다

여기서는 모든 노드를 거치는 방법을 선택해야 하기 때문에

```
public static void DFS(int start, int L) {
	if(L == 5) {
		flag = true;
		return;
	}
	
	chk[start] = true;
	for(int v : list.get(start)) {
		if(!chk[v]) {
			DFS(v, L+1);
		}
	}
	chk[start] = false;
}
```

이렇게 `chk[start]=false` 코드를 추가해줘야 함
