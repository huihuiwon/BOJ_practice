연합을 이룰 수 있는지 없는지는 BFS를 통해서 구현

```
boolean visit[][]=new boolean[n][n];
for(int i=0; i<n; i++) {
	for(int j=0; j<n; j++) {
		if(visit[i][j]) continue;
		
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[] {i, j});
		visit[i][j]= true;
		
		int count=1; int sum=map[i][j];
		ArrayList<int[]> arr =new ArrayList<>();
		while(!q.isEmpty()) {
			int cur[]= q.poll();
			for(int dir=0; dir<4; dir++) {
				int nx= cur[0]+dx[dir];
				int ny= cur[1]+dy[dir];
				
				if(nx<0 || ny<0 || nx>= n|| ny>=n) continue;
				if(visit[nx][ny]) continue;
				int diff = Math.abs(map[nx][ny]-map[cur[0]][cur[1]]);
				if(diff < l || diff > r) continue;
				
				count++;
				sum += map[nx][ny];
				q.add(new int[] {nx, ny});
				visit[nx][ny]=true;
				arr.add(new int[] {nx, ny});
			}
		}
		int tmp = sum/count;
		for(int a[] : arr) {
			map[a[0]][a[1]]=tmp;
		}
		if(count!=1) {
			map[i][j]=tmp;
			flag=true;
		}
	}
}
```

diff 변수를 이용해서 현재 보고 있는 칸과 다음 이동할 칸의 인구 차이를 구해줘야 한다</br>
이때 `Math.abs()`를 이용해서 절댓값으로 차이를 구해줘야 한다</br>
어느 국가의 인구가 더 많을 지 알 수 없기 때문</br>
만약 `diff < 1 || diff > r` 이라면 연합을 이룰 수 없으니 continue</br>
아니면 연합의 칸의 개수를 구하기 위해 count++ 을 해주고,</br>
연합의 인구수를 구하기 위해서 `sum+=map[nx][ny]` 를 해줘야 한다

마지막에 인구수를 구하고 나면 나라의 인구수가 바뀌기 때문에,</br>
미리 ArrayList에 넣어줬던 이동하는 국가들의 인덱스를 빼내가면서 갱신

이 과정을 인구 이동이 한 번도 없을 때까지 반복해줘야 한다</br>
이를 위해서 미리 `while(true)`로 감싸주고, `boolean flag= false`를 선언</br>
만약 `count == 1` 이라면, 인구 이동이 한 번도 없었다는 뜻</br>
count가 1이 아니면 인구수를 갱신해주면서 `flag= true`로 갱신해주는데,</br>
마지막에 flag가 false라면 갱신이 한 번도 되지 않았다는 뜻이다</br>
이때 break를 걸어서 while문 탈출

while문을 한 번 돌 때마다 `result++` 을 해서 며칠 동안 발생하는지 구해줘야 한다</br>
마지막에 result 값을 출력
