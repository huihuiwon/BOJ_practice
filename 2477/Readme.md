처음에 min_w, min_h 만 구하면 된다고 생각</br>
하지만 반례 발생</br></br>

max_h나 max_w를 구해놓고, for문을 돌면서 max_h나 max_w가 나오면 i+3번째 값과 i+4번째 값이 min_w나 min_h라고 생각</br>
하지만 max_h가 나오고 그뒤에 max_w가 아니면 i+2번째와 i+3번째 값이 min_h와 min_w이다</br></br>

```
for(int i=0; i<6; i++) {
	if(len[i]==maxw || len[i]==maxh) {
		if(len[i+1]==maxw || len[i+1]==maxh) {
			minw=len[(i+3)%6];
			minh=len[(i+4)%6];
			break;
		}
		else {
			minw=len[(i+2)%6];
			minh=len[(i+3)%6];
			break;	
		}
	}
}
```

따라서 경우를 나눠서 생각해줘야함</br>
index 오류 방지를 위해 %를 이용해서 구현해야한다
