A와 B 모두 1 이상 999 이하</br>
따라서 A의 가능한 길이는 1, 2, 3 중 하나

k를 A의 길이라고 생각</br>
처음에 k를 1로 두고, 하나씩 잘라도 문자열이 이어지는 지 확인</br>
이때 9로 시작해도 그 다음은 10 이런 식으로 자릿수가 바뀔 수 있으니,</br>
nxt를 구한 뒤에는 `(int)(Math.log10(nxt)+1` 로 자릿수를 구해줘야 한다

```
for(int k=1; k<=3; k++) {
	if(k>str.length()) break;
	int a = Integer.parseInt(str.substring(0, k));
	int nxt = a;
	boolean flag = true;
	for(int i=k; i<str.length(); i++) {
		nxt += 1;
		
		if(i+(int)(Math.log10(nxt)+1)>str.length()) {
			flag=false;
			break;
		}
		int tmp = Integer.parseInt(str.substring(i, i+(int)(Math.log10(nxt)+1)));
		if(tmp == nxt) {
			i+=(int)(Math.log10(nxt));
		}
		else {
			flag = false;
			break;
		}
	}
	if(flag) {
		System.out.println(a+" "+nxt);
		break;
	}
}
```

`str.substring()` 을 할 때는 범위가 넘는지 안 넘는지 확인을 해줘야 한다</br>
만약 범위가 넘는다면 그 문자열은 가능하지 않으므로 `flag=flase`를 하고 break

최종적으로 flag가 true라면, 구해놓은 a와 nxt를 출력</br>
nxt는 계속 갱신되기 때문에 가장 마지막에 갱신된 문자가 nxt에 들어가 있다
