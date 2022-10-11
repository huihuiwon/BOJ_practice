일반적으로 DFS는 더이상 갈 곳이 없으면 되돌아와서 다음 방향을 찾는데,</br>
이 경우는 후진해야 하는 경우가 아니면 되돌아가면 안된다

따라서

```
for(int dir = 0; dir<4; dir++) {
	int nd = (d+3-dir) % 4;
	int nx = x+dx[nd];
	int ny = y+dy[nd];
	
	if(nx < 0|| ny< 0|| nx>=n || ny>=m) continue;
	if(map[nx][ny]==1 || clean[nx][ny]) continue;
	clean[nx][ny]=true;
	ans++;
	DFS(nx, ny, nd);
	return;
}
```

이렇게 DFS를 돌리고 난 후에 return을 해줘야 함</br>
-> 이 부분에서 return 안 하고 다른 부분에서 return해서 틀렸음

왼쪽부터 봐야 하고, 결국 네 방향을 다 봐야 하니까</br>
for문을 써서 확인</br>
만약 for문을 돌다가 청소할 수 있는 공간이 있으면 재귀함수 호출

아니면 밑에서 후진할 수 있는지 없는지 확인

```
int bd = (d+2)%4;
int bx = x+dx[bd];
int by = y+dy[bd];

if(bx>=0 && by>=0 && bx<n && by<m) {
	if(map[bx][by] == 0) {
		DFS(bx, by, d);
	}
}
```
후진의 경우 위와 같다


처음에 단계를 너무 나눠서 생각했는데,</br>
1번과 2번 경우에 for문으로 한 번에 해결 가능
