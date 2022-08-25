T도 10 이하, N도 10 이하이므로 백트래킹으로 풀이</br>
가능한 모든 경우를 다 구해놓고 해당 경우를 계산했을 때 0이 되는지 확인</br>

```
DFS(n, L+1, str+" "+L);
DFS(n, L+1, str+"+"+L);
DFS(n, L+1, str+"-"+L);
```
으로 가능한 경우를 모두 구할 수 있다</br>
마지막에 아스키코드 순으로 정렬이 되어야 하기 때문에 공백 -> + -> - 순으로 DFS 구현</br></br>

만약 `if(L==n+1)` 이 된다면, N까지 다 str에 넣었다는 뜻이므로 이때 cal(str) 을 해서 결과가 0이면 str출력</br>
cal(str) 함수 안에서 str에 있는 공백을 제거하지만, 지역변수이므로 DFS 함수 안에 있는 str에는 영향이 안 간다</br></br>

split을 할 때는 split() 함수 혹은 StringTokenizer 모두 가능하지만</br>
이 경우 delimeter도 남기고 싶기 때문에 StringTokenizer 사용</br>
delimeter을 남기려면 `StringTokenizer st = new StringTokenizer(str, "+-", true);</br></br>

`for(int i=0; i<st.countTokens(); i++)` 을 하면 st.countToken이 가변값이기 때문에</br>
원하는 만큼 for문을 돌지 않을 수도 있다</br>
따라서 미리 변수에 넣어놓고, 해당 변수를 이용</br></br>

```
for(int i=2; i<cnt; i+=2) {
    if(st.nextToken().equals("+"))
        result+=Integer.parseInt(st.nextToken());
    else
        result-=Integer.parseInt(st.nextToken());
}
```
로 미리 result에 첫번째 토큰값을 넣어주고, 짝수번째 토큰이 +이면 더해주고 아니면 빼준다</br>
이렇게 result를 구하고 return 해주면 끝
