BFS로 풀려고 했으나 ㅓ,ㅜ,ㅗ,ㅏ 때문에 DFS로 풀어야 하는 문제</br>
그냥 DFS나 BFS로 예외 없이 풀이하면 저 네 가지 경우가 나오지 않는다</br>
다른 테트로미노와 다르게 한 번 되돌아갔다가 다시 가야하기 때문

기본적으로 다른 테트로미노는 DFS(1) 부터 돌려서 L==4가 되었을 때 return 하도록</br>
처음에 네 가지 예외를 위해서 제일 시작점(sx, sy)를 두고 x, y와 nx, ny를 이용해서 tx, ty를 구하도록 했는데</br>
ㅓ에서 계속 몇 가지 경로로는 이동하지 않는 것을 확인
</br></br></br>
**반례**</br>
3 3</br>
0 1 0</br>
1 1 0</br>
0 1 0</br>
-> 정답은 4여야 한다

되돌아가는 것을 표현하기 위해 원래 재귀함수를 돌릴 때 `DFS(L+1, nx, ny, sum+map[nx][ny])`를 해야 하지만</br>
`DFS(L+1, x, y, sum+map[nx][ny])`를 하면 손쉽게 해결 가능


***
예외 부분을 해결하는 방법을 찾지 못했다
좀더 단순하게 생각해보기
