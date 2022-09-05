import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.replaceAll("pi|ka|chu", "");
		
		if(str.length()==0) System.out.println("YES");
		else System.out.println("NO");
	}
}


***
문자열 치환하는 문제
replaceAll 을 이용해서 풀이 가능

처음에
str = str.replace("pi", "");
str = str.replace("ka", "");
str = str.replace("chu", "");
이렇게 풀이했는데, 만약 kpia 라면 YES가 나온다
처음 replace를 거친 후에 ka가 되고, 그 후에 공백이 되기 때문

따라서 한 번에 replace를 해줘야하는데,
replaceAll() 을 이용하면 되고 구분하고자 할 때는 '|' 를 사용해서 하면 된다
