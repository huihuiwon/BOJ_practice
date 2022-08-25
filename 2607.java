import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String str1=br.readLine();
		int ch[]=new int[26];
		for(char c : str1.toCharArray()) {
			ch[c-'A']++;
		}
		
		int ans=0;
		for(int i=0; i<n-1; i++) {
			String str=br.readLine();
			int ch2[]=new int[26];
			if(Math.abs(str1.length()-str.length()) > 1) continue;

			for(char c : str.toCharArray()) {
				ch2[c-'A']++;
			}
			
			int diff=0;
			if(str.length() == str1.length()) diff--;
			for(int j=0; j<26; j++) {
				if(ch[j]!=ch2[j]) diff+=Math.abs(ch[j]-ch2[j]);
			}
			if(diff<=1) ans++;
		}
		System.out.println(ans);
	}
}


***
처음에 HashMap을 이용해서 구현하려고 했으나 실패
HashMap의 keySet의 크기를 가지고 더 큰 쪽의 key를 살피면서 get한 값을 찾으려고 했는데,
keySet의 크기가 같은 경우를 따로 해주지 않아 오답 발생

하지만 알파벳 배열을 만들어서 구현하면 간단하고 쉽게 구현 가능하다
미리 ch[c-'A']를 통해 배열값을 채워놓고, 배열 값을 비교하면서 차이값을 diff에 저장

하지만 만약 ABC와 ABD가 있다면, 위의 코드대로 하면 diff는 2
실제로는 한 문자를 바꾸면 되니까 비슷한 단어
이를 위해 만약 문자열의 길이가 같다면, 미리 diff를 하나 감소시켜줘서 최종 diff가 1이하면 ans++
