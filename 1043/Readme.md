진실을 알고 있는 사람을 HashSet 안에 넣고,</br>
위에서부터 순서대로 만약 해당 파티에 있는 사람을 `hs.contains()` 했을 때 true라면 거짓말을 할 수 없다는 뜻</br>
그리고 그 사람들에게는 진실이 모두 알려져야 하므로 DFS를 돌려서 해당 파티원을 모두 HashSet에 넣는다

이때 처음 발생한 반례는
```
4 5
1 1
1 1
1 2
1 3
1 4
2 4 1
```
실제적으로 정답은 2이지만, 위에서부터 순서대로 진행했기 때문에</br>
마지막에서 두번째 파티에서 4가 진실을 알게 될 것이라는 것을 예상 못한다</br>
따라서 3이라는 오답 발생

이를 위해 

```
int map[][]=new int[m][n+1];
for(int i=0; i<m; i++) {
	map[i][0] = sc.nextInt(); boolean flag = true;
	for(int j=1; j<=map[i][0]; j++) {
		map[i][j]=sc.nextInt();
		if(hs.contains(map[i][j])) {
			flag= false;
		}
	}
	
	if(!flag) {
		for(int j=1; j<=map[i][0]; j++) {
			DFS(map[i][j]);
		}
	}
}
```

이 과정을 통해서 map 배열에 넣고, 해당 과정을 한 번 더 반복

```
3 3
1 3
1 1
2 1 2
2 2 3
```

하지만 이런 반례 또 생김</br>
실제 정답은 0이지만 1출력

따라서 해당 과정을 m번 수행하고, 만약 마지막 번째 수행이고 flag가 true라면 cnt++;
```
int cnt = 0;
for(int k=0; k<m; k++) {
	for(int i=0; i<m; i++) {
		boolean flag = true;
		for(int j=1; j<=map[i][0]; j++) {
			if(hs.contains(map[i][j])) {
				flag= false;
			}
		}
		
		if(k==m-1 && flag) cnt++;
		if(!flag) {
			for(int j=1; j<=map[i][0]; j++) {
				DFS(map[i][j]);
			}
		}
	}
}
```
