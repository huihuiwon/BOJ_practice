조합을 이용해서 풀려고 했는데 49/50 개로 자꾸 오답</br></br></br>


**오답코드**
```
static void DFS(int s, int L, int end, int cnt) {
		if(cnt >= ans) return;
		if(L == end) {
			
			int[][] tmp =new int[n][m];
			arrcpy(tmp, map);
			
			for(int i=0; i<end; i++){
				for(int j=0; j<m; j++) {
					tmp[arr[i]][j] = 1;
				}
			}
			
			if(chk(tmp)) {
				ans = Math.min(ans, cnt);
			}

			for(int i=0; i<end; i++){
				for(int j=0; j<m; j++) {
					tmp[arr[i]][j] = 0;
				}
			}
			
			if(chk(tmp)) {
				ans = Math.min(ans, cnt);
			}
		//	System.out.println(flag);
			return;
		}
		
		for(int i=s; i<n; i++) {
			if(chk[i]) continue;
			chk[i] = true;
			arr[L] = i;
			DFS(i+1, L+1, end, cnt+1);
			chk[i] = false;
		}
	}
 ```
 </br></br>
 **정답코드**
 ```
 static void DFS(int cnt, int L) {
		if(cnt >= ans) return;
		if(L == n) {
			if(chk(tmp)) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		DFS(cnt, L+1);
		
		for(int i=0; i<m; i++)
			tmp[L][i] = 0;
		DFS(cnt+1, L+1);
		
		for(int i=0; i<m; i++)
			tmp[L][i] = 1;
		DFS(cnt+1, L+1);
		
		for(int i=0; i<m; i++)
			tmp[L][i] = map[L][i];
	}
```

굳이 백트래킹을 이용해서 조합을 구한 후에 그 조합에 따라 행을 바꾸지 않고, DFS를 그대로 사용</br>
cnt는 약품을 투여한 횟수이므로, 만약 약품을 투여하지 않았다면 `DFS(cnt, L+1)`</br>
약품을 투여했다면 `DFS(cnt+1, L+1)` 로 처리

약품을 투여 가능한 최대 횟수는 K</br>
왜냐면 아무리 연속되지 않게 있어도 K번 약품을 주사하면 K개 이상 연속되게 된다

따라서 `if(L == n)` 이면 chk 함수를 통해서 K개 이상 연속한지 확인 후, 연속하다면, 즉 리턴 값이 true라면 ans를 갱신

시간 단축을 위해서 `if(cnt>=ans) return`

</br></br>
**연속된지 확인하는 코드**
```
static boolean chk(int[][] tmp_map) {
		for(int i=0; i<m; i++) {
			int cnt = 1;
			for(int j=1; j<n; j++) {
				if(cnt >= k) break;
				if(tmp_map[j-1][i] == tmp_map[j][i]) cnt++;
				else {
					cnt = 1;
				}		
			}
			if(cnt < k) {
				return false;
			}
		}
		return true;
	}
```
위는 K개 이상 연속한지 확인하는 코드</br>
주의할 점은 cnt의 초기값이 0이 아닌 1이라는 점!

그리고 K가 만약 1이라면 아무리 불연속적이어도 약품을 투여할 필요가 없으니 결과는 언제나 0
