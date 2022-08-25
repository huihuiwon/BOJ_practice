import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len=str.length();
		
		
		TreeSet<String> ts = new TreeSet<>();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<len-1; i++) {
			for(int j=i+1; j<len; j++) {
				String tmp1=sb.append(str.substring(0, i)).reverse().toString();
				sb=new StringBuilder();
				String tmp2=sb.append(str.substring(i, j)).reverse().toString();
				sb=new StringBuilder();
				String tmp3=sb.append(str.substring(j, len)).reverse().toString();
				sb=new StringBuilder();
				
				ts.add(tmp1+tmp2+tmp3);
			}
		}
		
		System.out.println(ts.first());
	}
}


***
변수 first와 second를 두고,
first는 i=0 ~ i<len-2 까지, seconde는 i=first+1 ~ i<len-1 까지 보면서
제일 작은 문자를 찾으면 그 문자를 기준으로 뒤집기를 수행하려고 했으나 오답

브루트포스를 이용해서 가능한 모든 경우를 다 구해준 후에,
TreeSet으로 정렬을 해서 ts.first() 를 이용해 첫번째 값을 출력하면
모든 가능한 경우 중에 가장 앞서는 값을 구할 수 있다
