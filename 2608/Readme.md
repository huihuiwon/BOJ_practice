## 문자열 & 치환

처음에 로마 숫자를 더하고 아라비아 숫자로 나타낼 때는 replace를 이용</br>

```
String arr1[]= {"IV", "IX", "XL", "XC", "CD", "CM", "I", "V", "X", "L", "C", "D", "M"};
String arr2[]= {"4 ","9 ","40 ","90 ","400 ","900 ","1 ","5 ","10 ","50 ","100 ","500 ","1000 "};

for(int i=0 ;i<arr1.length; i++) {
	n1 = n1.replace(arr1[i], arr2[i]);
	n2 = n2.replace(arr1[i], arr2[i]);
}
```

로마 숫자와 그에 해당하는 아라비아 숫자를 배열로 선언해놓고, for문을 돌면서 replace를 해준다</br>
그러면 만약 "IVIX"였던 로마 숫자는 "4 9 " 로 치환된다</br>
이때 주의할 점은 예외인 경우의 인덱스가 더 빨라야 한다는 것이다</br>
예외가 아닌 경우를 먼저 선언해버리면 이미 for문 앞에서 replace를 해버렸기 때문에 예외 처리가 안된다</br></br>

합을 구할 때는 공백으로 각 숫자가 끝났음을 명시해놓은 상태이므로, 공백을 이용해 split을 하고 값을 더한다</br>
이때 구한 최종 아라비아 숫자를 total로 선언

```
String arr3[]= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
int arr4[]= {1000,900,500,400,100,90,50,40,10,9,5,4,1};

while(total != 0) {
	for(int j=0; j<arr4.length; j++) {
		if(total>=arr4[j]) {
			total-=arr4[j];
			sb.append(arr3[j]);
			break;
		} 
	}
}
```

아라비아 숫자를 로마 숫자로 다시 바꾸는 방법은 다음과 같다</br>
가장 최소의 횟수를 구해야 하므로, 값이 큰 경우부터 선언을 해준다</br>
total이 0이 아닐 때까지 반복을 하면서,</br>
만약 `total >= arr4[j]` 라면 `total-=arr4[j]`를 하고 `sb.append(arr3[j])`
