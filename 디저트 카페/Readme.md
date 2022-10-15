핵심 포인트는 방향 회전을 4번 돌려야 하고, 방향 회전을 4번 돌린 이후에 처음 있었던 곳으로 돌아와야 한다는 것</br>
처음에 사각형을 표현하기 위해 어떻게 해야하지 고민햇는데, 방향을 네 번 돌고 나서 원래대로 돌아오면 결국 사각형이 그려져있음

```
public static void DFS(int sx, int sy, int x, int y, int dir, int turn) {
	if(turn == 4) {
		if(x==sx && y==sy) {
			int sum=0;
			for(int i=0; i<101; i++)
				if(desert[i])
					sum++;
			
			max = Math.max(max, sum);
			
		}
		return;
	}
	
	for(int d=0; d<4; d++) {
		int nx = x+dx[d];
		int ny = y+dy[d];
		if(nx < 0 || ny< 0 || nx >= n || ny>=n) continue;
		if(desert[map[nx][ny]]) continue;
		
		desert[map[nx][ny]] = true;
		if(dir == d)
			DFS(sx, sy, nx, ny, d, turn);
		else
			DFS(sx, sy, nx, ny, d, turn+1);
		visited[nx][ny] = false;
	}
}
```

DFS 매개변수로 cnt를 이용해서 몇 번 칸을 움직였는지 체크하려고 했으나 이상한 오답 발생</br>
마지막에 true로 갱신된 desert 배열값 개수를 세주면 그게 몇 칸 움직였는지와 동일

나머지는 기존 DFS와 거의 동일하다</br>
nx와 ny를 구한 후, 범위를 벗어나지 않는지 이미 갔던 곳은 아닌지 체크</br>
그 후 true로 갱신하고 DFS(L+1)을 한 후에, 만약 그렇게 갔던 곳을 안 갔어야 했던 경우를 위해서 false로 갱신해준다

방향이 바꼈다는 것은 현재 dir와 d가 다르다는 뜻!</br>
다르면 turn+1 아니면 turn
</br></br></br>
**시간초과 해결법**
1. boolean chk[][] 이중배열을 선언해서 이미 갔던 곳을 안 가게 체크했는데, </br>어차피 이미 갔던 곳이면 이미 먹은 디저트 -> 디저트 배열에서 체크하므로 두 번 할 필요 없음
2. 처음에 이중 for문에서 `dir=0; dir<4; dir++` 라고 했는데, </br>어차피 위에 있는 인덱스가 아래 인덱스를 돌기 때문에 dir 0과 1은 굳이 다시 돌려줄 필요 없음
