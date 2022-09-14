초록색이나 빨간색 배양액을 뿌릴 땅을 고를 때에는 조합을 이용

boolean chk 배열을 이용해서 각각 red 배열과 green 배열에 넣는다


```
public static void order(int L, int s) {
	if(L==g) {
		order_red(0, 0);
		return;
	}
	
	for(int i=s; i<cnt; i++) {
		if(chk[i]) continue;
		chk[i]=true;
		green[L]=i;
		order(L+1, i+1);
		chk[i]=false;
	}
}

public static void order_red(int L, int s) {
	if(L==r) {
		bfs();
		return;
	}
	
	for(int i=s; i<cnt; i++) {
		if(chk[i]) continue;
		chk[i]=true;
		red[L]=i;
		order_red(L+1, i+1);
		chk[i]=false;
	}
}
```

​

그 전에 만약 map[i][j]가 2라면 배양액을 뿌릴 수 있는 땅이므로,

미리 ArrayList에 해당 x좌표와 y좌표를 넣어준 후 get() 을 이용해서 뽑아낸다

```
for(int i=0; i<g; i++) {
	int gx[]=al.get(green[i]);
	g_dist[gx[0]][gx[1]]=1;
	dist[gx[0]][gx[1]]=1;
	q.add(new int[] {gx[0], gx[1]});
}
for(int i=0; i<r; i++) {
	int rx[]=al.get(red[i]);
	r_dist[rx[0]][rx[1]]=1;
	dist[rx[0]][rx[1]]=2;
	q.add(new int[] {rx[0], rx[1]});
}
```
​

red배열과 green 배열을 모두 찾아낸 후에는 bfs() 함수를 수행

꽃을 피웠는지 안 피웠는지와 무슨 배양액을 뿌렸는지 체크하기 위해 dist 배열을 따로 만들고,

같은 시간 안에 뿌려졌는지를 확인하기 위해 g_dist와 r_dist를 따로 만들어줘야 한다

​

만약 `dist[cur[0]][cur[1]]==3` 이라면 이미 꽃을 피운 것이므로

더이상 배양액을 퍼뜨리지 않고 종료

​

만약 `dist[cur[0]][cur[1]]==0` 이라면 아직 뿌리지 않은 것이므로

g_dist 또는 r_dist를 갱신하고 큐에도 넣어줘야 한다

​

아니면 꽃을 피울 수 있는 조건임을 체크하고 꽃을 피웠다면 count++

`Math.max()` 를 이용해서 가장 많이 피울 수 있는 꽃의 개수를 구한다

```
else if(dist[nx][ny]==1) { //그린
	if(dist[cur[0]][cur[1]]==2 && r_dist[cur[0]][cur[1]]+1==g_dist[nx][ny]) {
		count++;
		dist[nx][ny]=3;
	}
}
else {
	if(dist[cur[0]][cur[1]]==1 && g_dist[cur[0]][cur[1]]+1==r_dist[nx][ny]) {
		count++;
		dist[nx][ny]=3;
	}
}
```
