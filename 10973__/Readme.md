이전 순열을 구하는 문제</br></br>

백트래킹을 이용해서 가능한 모든 순열을 구한 후에 이전 순열을 구하면 당연히 시간초과 발생</br>
(N은 1이상 10,000 이하)</br>
따라서 다른 방법을 생각해줘야 한다</br></br>


```
for(int i=n-2; i>=0; i--) {
	int index=-1;
	for(int j=i+1; j<n; j++) {
		if(arr[i] > arr[j]) {
			index=j;
    	}
	}
}
```

for문을 i=n-2부터 돌면서, j는 i+1부터 보는데, 이때 만약 `arr[i] > arr[j]` 라면 `index=j` 로 갱신</br>
index는 음수값이 나올 수 없기 때문에 초기값을 -1로 선언해서 갱신이 되었는지 안되었는지 확인하게 한다</br>
`arr[i] > arr[j]` 를 만족하는 j 중에 가장 큰 값을 찾으면, arr[i]와 arr[j]의 위치를 바꾸고,</br>
arr[i+1]~arr[n-1]까지 내림차순으로 정렬