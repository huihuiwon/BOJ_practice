### Error가 발생하는 경우
1) _으로 시작하는 경우  ex) _asd
2) _으로 끝나는 경우  ex) asd_
3) 대문자로 시작하는 경우  ex) Asd
4) _가 두개 이상 연속으로 존재하는 경우  ex) asd__as
5) 대문자와 _가 함께 존재하는 경우  ex) asAd_a


### 변환하는 방법
* C++로 변환하는 법

Java는 첫 단어는 소문자로 쓰고 다음 단어부터는 첫 문자만 대문자로 사용</br>
따라서 split 함수를 이용해서 먼저 "_" 를 기준으로 split을 해준다</br>

```
System.out.print(tmp[0]);
for(int i=1; i<tmp.length; i++) {
  System.out.print(Character.toUpperCase(tmp[i].charAt(0)));
  for(int j=1; j<tmp[i].length(); j++) {
    System.out.print(tmp[i].charAt(j));
  }
}
```

그 후 이렇게 split된 tmp 배열을 이용해서 구현하는데,</br>
tmp[0]은 첫 단어이므로 소문자 그대로 사용하고</br>
아니면 첫 단어만 `toUpperCase` 를 이용해서 대문자로 바꾸고 나머지는 그대로 출력


* Java로 변환하는 법

C++은 단어를 구분하기 위해 "_"을 이용하고 변수명에 소문자만 사용한다

```
for(int i=0; i<str.length(); i++) {
  if(Character.isUpperCase(str.charAt(i))) {
    System.out.print("_");
    System.out.print(Character.toLowerCase(str.charAt(i)));
  }
  else
    System.out.print(str.charAt(i));
}
```

따라서 만약 대문자를 만나면, 단어의 새로운 시작이므로 "_"를 출력하고 해당 문자는 소문자로 변환</br>
아니면 소문자 그대로 출력한다


C++과 Java 모두 중간에 위의 Error가 발생하는 경우의 조건과 마주하면</br>
즉시 Error! 를 출력하고 return해서 함수를 끝내도록 한다
