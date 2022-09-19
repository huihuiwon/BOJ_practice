기준을 치즈로 잡지 말고 공기로 잡기!

무조건 제일 가장자리는 공기이므로 시작점은 (0, 0) 으로 선언</br>
사방향을 둘러보면서 만약 이미 방문했으면 continue</br>

`map[nx][ny]==1` 이면, 공기와 접촉된 치즈라는 뜻이므로</br>
`map[nx][ny]=0`으로 갱신하고, 미리 구해둔 치즈의 개수에서 하나 감소</br>
치즈가 다 녹기 직전 치즈의 개수도 알고 싶으므로 `tmp++`

만약 공기라면, 다른 곳도 둘러봐야하므로 큐에 공기를 집어 넣어야 한다

여기서 핵심은 큐에 치즈가 들어가는 것이 아니라 공기가 들어가는 것!</br>
다음 칸이 치즈든 공기든 방문한 표시는 남겨야 한다

만약 무한 반복문을 돌다가 치즈의 개수가 0이 된다면,</br>
치즈가 다 녹은 것이므로 미리 구해둔 result와 tmp 값을 출력


***
빙산 문제와 비슷하다고 생각했으나 아니었다</br>
빙산 문제의 경우 일단 옆에 물이 있기만 하면 녹는 것인데, 이 문제는 공기가 아닌 구멍일 수도</br>
for문을 돌려서 사방에 치즈가 하나도 없다면 공기.. 로 구현하려고 했으나 실패