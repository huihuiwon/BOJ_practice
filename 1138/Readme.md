N이 4이고, 주어진 정보가 `2 1 1 0` 일 때</br>
![image](https://user-images.githubusercontent.com/50469773/183576805-84da0601-41de-4311-813e-760fe200beba.png)
</br></br>

주어진 정보의 배열을 arr[] 라고 선언</br>
for문을 도는데 뒤에서부터 돌면서 순서를 확인한다</br>
우선 제일 마지막 n번째 사람은 키가 제일 큰 사람이므로 무조건 `arr[n-1]=0`</br>
`ArrayList<Integer> result` 를 선언하고 거기에 N을 먼저 넣는다</br></br>

그 후에는 `for(int i=n-2; i>=0; i--)` 까지 돌면서 확인하는데,</br>
`arr[i]==0 이라면` 왼쪽에 자신보다 키 큰 사람이 없다는 뜻</br>
하지만 for문을 뒤에서부터 돌기 때문에 먼저 줄 세운 사람들은 무조건 자기보다 크다</br>
그러니까 `result(0, i+1)`로 제일 앞에 세워줘야함</br></br>

아니면 `result(arr[i], i+1)`을 하는데 만약 `result.size()<=arr[i]` 라면? 인덱스 에러가 뜰 것</br>
그리고 그런 경우에는 result 마지막에 넣어주면 되기 때문에 `result.add(i+1)`</br>
아니면 `result(arr[i], i+1)`을 해준다
