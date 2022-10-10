## 덱과 배열 이용한 문제
상 (0) 우 (1) 하 (2) 좌(3)

|현재|L|D|
|--|--|--|
|0|3|1|
|1|0|2|
|2|1|3|
|3|2|0|

벽과 몸을 2로, 사과는 1로 표현

덱을 이용해서 덱의 First는 꼬리, 덱의 Last는 머리로 표현</br>
처음에 큐를 이용하려고 생각했으나 꼬리의 위치와 머리의 위치가 모두 필요하므로 덱을 이용
</br></br></br>
**꼬리와 머리 이동**
```
dq.addLast(new int[] {nx, ny, cur[2]});
if(map[nx][ny] != 1) {
	int tmp_remove[] = dq.pollFirst();  // 꼬리
	map[tmp_remove[0]][tmp_remove[1]]=0;
}
map[nx][ny]=2;
```

이 부분은 다음 머리 위치를 일단 뽑아낸 후에, 만약 `map[nx][ny]!=1`이 아니라면, 즉 사과를 먹지 않았다면</br>
꼬리를 이동시켜 길이를 유지시켜야 함

`dq.pollFirst()`는 꼬리이므로, 꼬리를 이동시켰다는 표현을 하기 위해 0으로 갱신 (2라면 뱀이 있다는 뜻)</br>
머리는 일단 무조건 이동하므로, `map[nx][ny]=2`

처음에 map[nx][ny]를 갱신시켜주고 난 후에 if문을 걸었는데, 2로 갱신한 후이니 if문에는 무조건 걸리지 않는다
</br></br></br>
**방향 이동**
```
int cur[] = dq.peekLast();
int head[] = dq.pollLast();
if(cur[2]==0) {
	if(b=='L') dq.addLast(new int[] {head[0], head[1], 3});
	else dq.addLast(new int[] {head[0], head[1], 1});
}
else if(cur[2]==1) {
	if(b=='L') dq.addLast(new int[] {head[0], head[1], 0});
	else dq.addLast(new int[] {head[0], head[1], 2});
}
else if(cur[2]==2) {
	if(b=='L') dq.addLast(new int[] {head[0], head[1], 1});
	else dq.addLast(new int[] {head[0], head[1], 3});
}
else {
	if(b=='L') dq.addLast(new int[] {head[0], head[1], 2});
	else dq.addLast(new int[] {head[0], head[1], 0});
}
```

현재 방향을 확인한 후, 방향 갱신</br>
poll한후 add를 해줘야 방향이 바뀐 것만 들어감</br>
만약 add만 한다면 방향을 바꾸기 전과 후가 모두 들어감

***
### 실수했던 부분
1. NxN 배열을 중간에 만들어두고 벽을 2로 표현하려고 했는데 map[i][N]=2 라고 표현 (map[i][N+1]==2 여야함)
2. 예제2번의 경우, 방향 변환이 모두 끝난 후 혼자 이동하다가 자기 몸에 부딪힘 -> while(true) 로 계속 이동해줘야 함
3. 정수 X는 시작으로부터 X초! (X초가 끝난 후 다시 다음 X 시작이라고 생각)
