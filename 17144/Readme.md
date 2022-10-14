큐로 확산하는 부분을 표현했지만 큐가 아니라
그냥 배열을 그대로 사용해도 되는 문제

큐로 하려면 주의해야할 점은,
한 번 spread를 한 이후 큐를 새로 선언하고
큐에 미세먼지를 새로 넣어야한다는 것

그리고 공기 순환 부분에서 부등호 방향을 잘못 선언해서
순환이 다 이뤄지지 않았다

순환하는 방법은
```
public static void fresh() {
		//반시계
		for(int i= air1-1; i>0; i--) // 왼
			tmp[i][0] = tmp[i-1][0];
		
		for(int i=0; i<m-1; i++)  // 위
			tmp[0][i] = tmp[0][i+1];
		
		for(int i=1; i<=air1; i++)  // 오
			tmp[i-1][m-1] = tmp[i][m-1];
		
		for(int i=m-1; i>1; i--)  // 아
			tmp[air1][i] = tmp[air1][i-1];
		tmp[air1][1] = 0;
		
		for(int i=air2+1; i<n-1; i++)
			tmp[i][0] = tmp[i+1][0];
		
		for(int i=0; i<m-1; i++)
			tmp[n-1][i] = tmp[n-1][i+1];
		
		for(int i=n-1; i>=air2; i--)
			tmp[i][m-1] = tmp[i-1][m-1];
		
		for(int i=m-1; i>1; i--)
			tmp[air2][i] = tmp[air2][i-1];
		tmp[air2][1] = 0;
	}
  ```
  
  반시계는 시계방향으로, 시계는 반시계방향으로 보면서 갱신
