[백준 11000 풀이](https://blog.naver.com/njhw20/222799918218)</br>
백준 11000번 문제와 아주 유사</br></br>

핵심은 모든 강의실을 사용해야한다는 것!</br>
따라서 우선순위큐를 사용해서 풀어야 한다</br></br>

만약 `while(!pq.isEmpty() && pq.peek() <= arr.get(i).s)` 이면 `pq.poll()` 하고</br>
`pq.add(arr.get(i).e)` 를 해야 한다</br>
`result = Math.max(result, pq.size())` 를 해서 최종적으로 가장 컸던 `pq.size()`가 정답이 된다
