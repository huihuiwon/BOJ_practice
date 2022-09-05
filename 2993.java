import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		
		TreeSet<String> ts = new TreeSet<>();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<len-1; i++) {   // 0이면 처음 부분에 공백일 수도 있음
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
