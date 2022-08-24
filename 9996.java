import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String pat=br.readLine();
		String tmp[]=pat.split("\\*");
		int len=tmp[0].length()+tmp[1].length();
		for(int i=0; i<n; i++) {
			String com=br.readLine();
			
      // len을 비교해주지 않으면 a*a가 패턴일 때 a도 DA라 출력
			if(com.length()>=len && com.startsWith(tmp[0]) && com.endsWith(tmp[1])) {
				System.out.println("DA");
			}
			else
				System.out.println("NE");
		}
	}
}
