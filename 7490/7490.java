import java.io.*;
import java.util.*;


public class Main {

	public static int cal(String str) {
		str=str.replace(" ", "");
		StringTokenizer st = new StringTokenizer(str, "+-", true);
		int cnt=st.countTokens();
		
		int result=Integer.parseInt(st.nextToken());
		for(int i=2; i<cnt; i+=2) {
			if(st.nextToken().equals("+"))
				result+=Integer.parseInt(st.nextToken());
			else
				result-=Integer.parseInt(st.nextToken());
		}
	//	System.out.println(str+" "+result);
		return result;
	}
	public static void DFS(int n, int L, String str) {
		if(L==n+1) {
			if(cal(str)==0)
				System.out.println(str);
			return;
		}
		
		DFS(n, L+1, str+" "+L);
		DFS(n, L+1, str+"+"+L);
		DFS(n, L+1, str+"-"+L);
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			DFS(n, 2, "1");
            System.out.println();
		}
	}
}
