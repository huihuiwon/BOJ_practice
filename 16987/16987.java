import java.util.*;
import java.io.*;


public class Main {	

	static int n;
	static boolean chk[];
	static int s[];
	static int w[];
	
	static int ans = 0;
	public static void order(int L) {
		if(L==n) {
			int cnt=0;
			for(int i=0; i<n; i++)
				if(s[i] <= 0) cnt++;

			ans = Math.max(cnt, ans);
			return;
		}
		
		if(s[L] <= 0) order(L+1);
		else {
			boolean chk = false;
			for(int i=0; i<n; i++) {
				if(L==i || s[i] <= 0) continue;
				s[i]-=w[L];
				s[L]-=w[i];
				chk = true;
				order(L+1);
				s[i]+=w[L];
				s[L]+=w[i];
			}
			if(!chk) order(L+1);
		}
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();

		s=new int[n];
		w=new int[n];
		for(int i=0; i<n; i++) {
			s[i]=sc.nextInt(); w[i]=sc.nextInt();
		}
		
		order(0);
		System.out.println(ans);
		
	}
	
}
