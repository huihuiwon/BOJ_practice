현재 위치를 cur로 잡고,</br>
사과가 떨어진 위치(want)가 cur 이상이고 cur+m 이하이면</br>
바구니의 위치를 옮기지 않아도 되므로 continue</br></br>

만약 want가 cur+m 이상이면, 바구니를 이동해야 함</br>
이때 cur이 3이고 m이 1인데 want가 6이면 현재 바구니 위치는 3-4</br>
4-5, 5-6 이렇게 2칸 가면 됨</br>
따라서 result와 cur 은 `want - (cur+m)`</br></br>

만약 want가 cur+m 미만이라면? `want - (cur+m)` 을 하면 음수가 나옴</br>
그리고 현재 cur이 5이고 want가 4면 한 칸만 이동하면 된다</br>
따라서 `result += cur - want`</br>
그리고 `cur += want - cur`
