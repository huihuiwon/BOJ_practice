구역의 크기는 N X N</br>
다만 행이나 열이 0이거나 N-1이면 특수 약품이 칠해져있기 때문에 미생물 양이 절반이 되고 방향도 반대로 바뀜</br>
처음에 구역의 크기가 N+2 X N+2 라고 생각 -> 문제 잘 봐야함

1. 처음에 미생물이 있는 위치와 미생물의 개수, 방향을 큐에 담아둔다</br>
2. 그 후 객체 배열을 선언</br>
3. 큐가 빌 때까지 보면서 새로운 방향에 미생물을 넣어줌</br>
4. 배열의 값을 큐로 다시 넘김

1번부터 4번까지 과정을 반복</br>
이때 주의할 점은 세 방향 이상의 곳에서 미생물이 합쳐지는 경우</br>
만약 10, 15, 20 이 있을 때 20 방향으로 갱신되어야 하지만</br>
10부터 차례대로 합쳐졌다면 15의 방향으로 갱신되고 끝난다</br>
-> 어떻게 해결해야할지 헤맸던 부분

이를 해결하기 위해 PriorityQueue를 사용!</br>
아예 qNode 라는 객체를 선언해서 미생물의 개수를 내림차순으로 선언하면</br>
무조건 미생물이 큰 것부터 비교하기 때문에 10, 15, 20 이 있으면 20부터 살펴봄</br>
그러면 갱신하는 과정에서 제일 큰 값의 방향대로 갱신된다
</br></br></br>
***1초가 지난 후 배열***
```
if(nx == 0 || ny == 0 || nx == n-1 || ny == n-1) {
	if(map[nx][ny].num == 0)
		map[nx][ny] = new Node(cur.num/2, move[cur.dir]);
	else {
		if(map[nx][ny].num > cur.num/2)
			map[nx][ny] = new Node(map[nx][ny].num + cur.num/2, map[nx][ny].dir);
		else
			map[nx][ny] = new Node(map[nx][ny].num + cur.num/2, move[cur.dir]);
	}
}
else {
	
	if(map[nx][ny].num == 0)
		map[nx][ny] = new Node(cur.num, cur.dir);
	else {
		if(map[nx][ny].num > cur.num)
			map[nx][ny] = new Node(map[nx][ny].num + cur.num, map[nx][ny].dir);
		else
			map[nx][ny] = new Node(map[nx][ny].num + cur.num, cur.dir);
	}
}
```

그리고 객체 배열을 사용하고 싶다면, 처음에 초기화 과정을 거쳐야 한다</br>
아니면 안에 null로 초기화 되어있음
</br></br>
***객체 배열 초기화 과정***
```
map = new Node[n][n];
for(int i=0; i<n; i++)
	for(int j=0; j<n; j++)
		map[i][j] = new Node(0, 0);
```
