[불!](https://www.acmicpc.net/problem/4179) 문제와 매우 유사

먼저 물이 이동하는 데 걸리는 시간을 모두 구해놓는다</br>
water[][] 배열에 선언</br>
BFS를 이용하여 구현하되, `if(water[nx][ny] != -1 || map[nx][ny]=='D' || map[nx][ny]=='X')`라면 continue</br>
왜냐면 돌을 통과할 수 없고 굴도 통과할 수 없기 때문

그 후 고슴도치가 이동하는 데 걸리는 시간을 구한다</br>
dist[][] 배열에 선언

```
if(dist[nx][ny] != -1 || map[nx][ny]=='*' || map[nx][ny]=='X') continue;</br>
if(dist[cur[0]][cur[1]]+1 >= water[nx][ny] && map[nx][ny] != 'D' && water[nx][ny]!=-1) continue;
```

윗줄 조건은 물이 이동할 수 없는 조건과 비슷</br>
하지만 고슴도치는 이미 물이 이동한 곳으로는 이동할 수 없으니 `dist[cur[0]][cur[1]]+1 >= water[nx][ny]` 조건 필요</br>
그리고 water이나 dist나 초기값이 -1이기 때문에, 지나치지 않은 곳은 -1</br>
만약 뒷 조건이 없다면

```
2 2
S.
.D
```

에서 KOKTUS가 출력된다</br>
왜냐면 water[nx][ny]는 항상 -1이므로, dist[nx][ny]보다 작기 때문
