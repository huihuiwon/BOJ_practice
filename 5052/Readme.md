전화번호가 주어졌을 때, 전화번호의 길이는 10자리 이하이므로 int형의 범위를 넘는다</br>
Long형으로 선언을 하든지 해야하는데 한 자리씩 비교를 원하니 String형으로 선언하는 것이 더 편리</br></br>

String형으로 번호들을 입력받은 후, 정렬을 수행</br>
처음에 `Arrays.sort()`를 하는 과정에서 `(int)Long.compare` 로 했기 때문에 오답 발생</br>
Long형을 int로 바꾸는 과정에서 잘못된 값이 들어간다</br>
String형으로 선언된 배열은 그냥 `Arrays.sort()`를 해도 문제가 되지 않으니 정렬</br></br>

그리고 기본적으로 `chk=false`로 선언해놓고, `flag=false`로 선언</br>
이때 flag는 각 for문마다의 boolean</br>
만약 arr[i]와 arr[i+1]이 있을 때, `for(int j=0; j<arr[i].length(); j++)` 까지 돌렸을 때</br>
하나라도 다르면 포함되지 않는 것</br>
이럴 때는 `flag=true`로 갱신</br></br>

만약 for문을 한 번 돌렸을 때, flag가 false라면, 모두 같다는 뜻</br>
이럴 때는 `chk=true`로 갱신하고 break를 한다</br></br>

마지막에 chk가 true라면 NO, 아니면 YES를 출력</br></br></br>


더 간단하게 하려면 `startsWith`를 사용 가능</br>
`startsWith()` 함수를 쓰면 특정 문자 혹은 특정 문자열로 시작하는 지 간단하게 확인 가능</br>
`arr[i+1].startsWith(arr[i])`로 간단히 구현 가능하다</br></br>


***
1. Arrays.sort를 하는 과정에서 오류 발생
2. if(arr[i].charAt(j) != arr[i+1].charAt(j)) 부분에서 인덱스 에러 발생
   arr[i+1]의 길이가 arr[i]보다 무조건 길다는 보장은 없다
   arr[i+1]의 길이보다 arr[i]가 길다면, arr[i]는 arr[i+1]에 포함되지 않는다
   다르게 말하면 일관성이 있다는 뜻!
   이럴 때는 그냥 flag=true 하고 continue
