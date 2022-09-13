섬을 구분하기 위해서 먼저 BFS를 돌려서 섬에 번호를 매겨준다

```
int cnt=0;
for(int i=0; i<n; i++) {
  for(int j=0; j<n; j++) {
    if(chk[i][j]!=0 || map[i][j]==0) continue;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {i, j});
    cnt++;
    chk[i][j]= cnt;

    while(!q.isEmpty()) {
      int cur[]=q.poll();
      for(int dir=0; dir<4; dir++) {
        int nx=dx[dir]+cur[0];
        int ny=dy[dir]+cur[1];
        if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
        if(map[nx][ny]==0 || chk[nx][ny]!=0) continue;
        q.add(new int[] {nx, ny});
        chk[nx][ny]=cnt;
      }
    }
  }
}
```

코드는 위와 같고, 백준 문제 중에 그림 문제와 거의 유사

이렇게 하고 나면 chk 배열에는 섬이면 섬의 번호, 바다면 0이 들어가 있게 된다

이제 구해야 하는 것은 섬 간의 거리</br>
섬의 거리를 구하기 위해 방문하지 않은 섬, 즉 `map[i][j]!=0` 이라면 함수를 수행

```
public static void make(int[][] map, int n, int i, int j, int[][] dist, int gn) {
	Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {i, j});
    dist[i][j]=0;
    
    while(!q.isEmpty()) {
        int[] cur = q.poll();
        for(int idx = 0; idx < 4; idx++)  {
            int mx = cur[0] + dx[idx];
            int my = cur[1]+ dy[idx];

            if(mx<0 || my<0 || mx>=n || my>=n || map[mx][my] == gn || dist[mx][my]!=-1) continue;
            if(map[mx][my] == 0)  {
                dist[mx][my] = dist[cur[0]][cur[1]]+1;
                q.add(new int[] {mx,my});
            }
            else if(map[mx][my] == 1 && chk[mx][my] != chk[i][j]){
            	min = Math.min(min,dist[cur[0]][cur[1]]);
            }
            
        }
    }	
}
```

gn은 섬의 번호</br>
gn을 이용하는 이유는 같은 섬 안에서 이동했는 것인데 섬 간의 거리라고 생각하지 않기 위함</br>
이는 코드에서 `map[mx][my]==gn` 으로 나타나져있다

또, 만약 `map[mx][my]==0` 이라면 바다이므로 계속 거리를 구하는데</br>
아니라면 이제 섬 간의 최솟값을 구할 수 있다

하지만 그냥 else 로 하면 최솟값은 0이나 -1이 출력</br>
`chk[mx][my] != chk[i][j]` 으로 현재는 섬이거나 바다이고, 다음 이동할 곳은 바다이거나 섬임을 확인해야 한다

이 부분을 하지 않아서 계속 0이나 -1이 출력됐었음
