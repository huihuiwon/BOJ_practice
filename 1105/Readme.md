만약 L과 R의 길이가 다르다면 나올 수 있는 8의 최소 개수는 0</br>
L과 R의 길이가 같을 때, 8의 최소 개수를 구해야 한다</br></br>

`for(int i=0; i<nn.length(); i++)` 까지 for문을 돌려서 숫자를 비교</br>
만약 `if(nn.charAt(i) == '8' && kk.charAt(i) == '8')` 라면 `cnt++`를 해준다</br>
이때 `else if(nn.charAt(i) != kk.charAt(i))` 면 break 해줘야 한다</br>
만약 L이 78이고 R이 88 이라면, 79 라는 8이 하나도 없는 선택지가 있다</br></br>

처음에
```
for(int i=0; i<nn.length(); i++) {
	if(nn.charAt(i) == '8' && kk.charAt(i) == '8') {
	  if(i==0 || nn.charAt(i-1)==kk.charAt(i-1))
		  cnt++;
	}
}
```
라고 구현했는데 틀렸다</br>
왜냐면 앞에 숫자가 모두 같고, 똑같은 위치에서 8이 있어야지 8을 피할 수 없기 때문</br>
앞에서부터 하나라도 어긋나면 8을 피할 수 있다
