DFS로 풀면 시간초과가 났던 문제 -> BFS로 풀이!

M이 100,000개 이하의 자연수이고 N이 10,000 이하의 자연수이기 때문에 인접 리스트로 표현

```
list = new ArrayList<ArrayList<Integer>>();
for(int i=0; i<=n; i++)
  list.add(new ArrayList<Integer>());

for(int i=0; i<m; i++) {
  tmp = br.readLine().split(" ");
  int a = Integer.parseInt(tmp[0]); int b = Integer.parseInt(tmp[1]);
  list.get(a).add(b);
}
```

가장 많은 컴퓨터를 해킹하려면 그만큼 신뢰 가능한 관계가 많다는 뜻</br>
나와 연결된 컴퓨터들의 개수를 셌을 때, 그 개수가 가장 많다면 그 컴퓨터를 해킹해야한다!

```
public static void BFS(int start) {
  Queue<Integer> q = new LinkedList<>();
  chk[start]=true;
  q.offer(start);

  while(!q.isEmpty()) {
    int x = q.poll();
    for(int v : list.get(x)) {
      if(!chk[v]) {
        chk[v]=true;
        result[v]++;
        q.offer(v);
      }
    }
  }
}
```

위의 BFS를 1부터 N까지 돌리고 나면 result 배열 안에 연결된 컴퓨터의 개수가 남게 된다</br>
`Math.max()` 함수를 통해 최댓값을 구하고, 그 값과 동일하다면 출력
