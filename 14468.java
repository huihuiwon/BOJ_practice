import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str = br.readLine();
    	int s[]=new int[26];
    	int e[]=new int[26];
    	for(int i=0; i<52; i++) {
    		int index = str.charAt(i)-'A';
    		if(s[index]==0) s[index]=i+1;
    		else e[index]=i+1;
    	}
    	
    	int result=0;
    	for(int i=0; i<26; i++) {
    		for(int j=0; j<26; j++) {
    			if(s[i]<s[j] && e[i]<e[j] && s[j]<e[i]) result++;
    		}
    	}
    	System.out.println(result);
    }
}

***
경로가 겹치려면 필요한 조건
1. A 시작점 < B 시작점 // s[i] < s[j]
2. A 끝점 < B 끝점 // e[i] < e[j]
3. B 시작점 < A 끝점 // s[j] < e[i]

여기서 s배열이 시작점을 담은 배열, e배열이 끝점을 담은 배열
i가 A, j가 B이다

그리고 배열에 담을 때 그냥 i를 해버리면
정말 0인 값이 담긴 배열과 초기 배열을 구분할 수 없다

구분을 원활하게 하기 위해 i+1을 해서 초기값과 구분되게
