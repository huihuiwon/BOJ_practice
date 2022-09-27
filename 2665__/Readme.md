그냥 미로를 탐색하는 것이 아니라 바꿔야 할 때는 바꾸면서 탐색하는 문제</br>
이럴 때는 삼차원 배열을 이용해서 마지막 인덱스에는 바뀐 개수를 넣어주면 간단하게 풀이 가능

이 경우 N은 최대 50이고, 그렇다면 모든 방이 검은색이라 쳤을 때 바꿔야하는 방의 개수는 최대 100</br>
// 처음에 50*50 이라 생각했는데 (메모리 초과 이유) 이 경우는 되도록 적은 수의 방의 색을 바꾸고 싶다</br>
-> 만약 모든 방이 1이라면 최단 거리를 사용해야 하고 최단 거리는 N+N

```
while(!q.isEmpty()) {
	int cur[] = q.poll();
	for(int dir=0; dir<4; dir++) {
		int nx = cur[0]+dx[dir];
		int ny = cur[1]+dy[dir];
		
		if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
		if(nx==n-1 && ny==n-1){
			min = Math.min(cur[2], min);
			break;
		}
		if(cur[2] >= n*n) continue;
		if(map[nx][ny] == 1) {
			if(visit[nx][ny][cur[2]]) continue;
			q.add(new int[] {nx, ny, cur[2]});
			visit[nx][ny][cur[2]] = true;
		}
		else {
			if(visit[nx][ny][cur[2]+1]) continue;
			q.add(new int[] {nx, ny, cur[2]+1});
			visit[nx][ny][cur[2]+1] = true;
		}
	}
}
```

구체적인 풀이는 다음과 같다</br>
만약 다음에 이동할 칸이 하얀 색, 즉 1이라면</br>
`visit[nx][ny][cur[2]]`가 true인지 확인하고 아니면 큐에 넣고, true로 변환

만약 다음 칸이 검은 색이라면</br>
마찬가지로 `visit[nx][ny][cur[2]+1]`이 true인지 확인하고 아니면 큐에 넣고 true로 변환

nx와 ny를 구한 다음에는 이 값이 n-1인지 확인을 해줘야 하는데,</br>
이때 그냥 return을 해버리면 최소값을 찾지 않고 처음 출구를 발견하면 바로 리턴

따라서 `Math.min()` 을 이용한 후 break를 해줘야 한다
