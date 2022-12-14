import java.util.*;
import java.io.*;


public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String dp[]=new String[1001];
		
		dp[1]="SK";
		for(int i = 1; i<=n; i++) {
			if(i+1 <= n) dp[i+1] = dp[i].equals("SK") ? "CY" : "SK";
			if(i+3 <= n) dp[i+3] = dp[i].equals("SK") ? "CY" : "SK";
		}
		
		System.out.println(dp[n]);
	}
}
