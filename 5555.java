import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len=str.length();
		int n=Integer.parseInt(br.readLine());
		
		int ans=0;
		for(int i=0; i<n; i++) {
			String com=br.readLine();
			com += com;
			if(com.contains(str)) ans++;
		}
		
		System.out.println(ans);
	}
}


***
반지에 해당하는 문자열이 몇개 있냐가 아니고
해당하는 문자열이 포함된 반지가 몇개이냐 가 문제!
  
따라서 반지의 문자열에 반지의 문자열을 한 번 더 더해주고 (시작과 끝이 연결되어있으니까)
contains() 함수를 이용해 알 수 있다
