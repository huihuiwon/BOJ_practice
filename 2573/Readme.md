## BFS

두 덩어리 이상으로 나누어지는 지 확인하기 위해 count() 함수를 빙산이 녹을 때마다 실행시켜줘야 한다</br>
빙산이 녹을 때 큐 하나, 덩어리 개수를 확인할 때 큐 하나 즉 큐 2개를 사용하는 문제</br></br>

```
public static int count() {	
	boolean chk[][]=new boolean[h][w];
	int cnt=0;
	for(int i=0; i<h; i++) {
		for(int j=0; j<w; j++) {
			if(chk[i][j] || map[i][j]==0) continue;
			cnt++;
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {i, j});
			chk[i][j]=true;
			while(!q.isEmpty()) {
				int cur[]=q.poll();
				for(int dir=0; dir<4; dir++) {
					int nx=dx[dir]+cur[0];
					int ny=dy[dir]+cur[1];
					if(nx<0 || nx>=h || ny<0 || ny>=w) continue;
					if(chk[nx][ny] || map[nx][ny]==0) continue;
					chk[nx][ny]=true;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
	
	return cnt;
}
```
덩어리 개수를 구하는 함수는 다음과 같다</br>
cnt 변수를 선언 (덩어리 개수) 최종적으로 구한 덩어리 개수를 return 해주는 함수


```
boolean now[][]=new boolean[h][w];
while(!q.isEmpty()) {
	int cur[]=q.poll();
	int z_cnt=0;
	for(int dir=0; dir<4; dir++) {
		int nx=dx[dir]+cur[0];
		int ny=dy[dir]+cur[1];
		if(nx<0 || nx>=h || ny<0 || ny>=w) continue;
		if(map[nx][ny]==0 && !now[nx][ny]) z_cnt++;
	}
	map[cur[0]][cur[1]] -= z_cnt;
	if(map[cur[0]][cur[1]] < 0) map[cur[0]][cur[1]]=0;
	now[cur[0]][cur[1]]=true;
}
```
빙산이 녹는 부분을 표현하는 부분은 다음과 같다</br>
now 배열을 이용해서 현재 시간에 녹은 것인지 아닌지 체크한다</br>
아니면 동시간에 녹은 것인데 높이가 0이 되었다고 빙산이 줄어드는 데 관여하지 않아야하는데 관여한다고 체크할 수 있다</br>
시간 초과를 줄이기 위해서 map[i][j] 가 0이 아닌 값들만 큐에 넣고,</br>
z_cnt 를 구해준다</br>

이렇게 map 배열을 갱신한 후에는 count() 함수를 수행해서 덩어리 개수를 구해준다</br>
이 과정을 계속 반복하는데, map[i][j]가 0이 아닌 것들을 넣어놓은 큐의 사이즈가 0이라면 (즉 다 녹았다면) return</br>
혹은 count() 함수를 수행한 결과가 2 이상이면 ans 값을 구해주고 return</br>

그리고 애초에 덩어리가 2개 이상이었을 가능성도 있으니, 처음에 count() 함수를 수행하고 while문을 돌려야 한다
