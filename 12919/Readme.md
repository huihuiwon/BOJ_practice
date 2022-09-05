S부터 시작해서 뒤에 A를 추가하거나 B를 추가하고 뒤집는 방식으로 연산을 했을 때 T가 나오는지 확인 -> 시간초과 발생</br>
T에서 시작해서 문자열을 줄이는 방식으로 해야 시간초과를 막을 수 있다</br></br>

만약 현재 보고 있는 문자열, 즉 str의 제일 마지막 문자가 A라면?</br>
A를 추가했을 가능성이 있다</br>
-> `chk(L-1, str.substring(0, str.length()-1));`</br></br>

만약 str의 제일 첫 번째 문자가 B라면?</br>
```
StringBuilder sb = new StringBuilder(str.substring(1, str.length()));
sb = sb.reverse();
chk(L-1, sb.toString());
```

`substring(1, str.length())` 를 이용해서 두 번째 문자부터 마지막 문자까지를 StringBuilder에 넣고</br>
그 후 `sb.reverse()`를 이용해서 뒤집어준다</br>
이러면 두번째 연산 조건인 "뒤에 B를 추가하고 문자열을 뒤집는다" 를 수행하기 전으로 돌릴 수 있다
</br></br>
처음에 `if(str.charAt(str_len-1)=='A')` 를 하고 `else if(str.charAt(0)=='B')` 를 했는데 반례 발견</br>
S가 A이고 T가 BABA일 때</br>
BABA -> BAB -> BA -> B 이렇게 된다</br>

실제로는 BA 다음 두번째 연산을 이용해서 A가 될 수 있음</br>
따라서 `else if` 가 아니고 `if` 를 사용해줘야 한다
