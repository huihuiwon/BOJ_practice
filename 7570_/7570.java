import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int dp[]=new int[n+1];
		int max=0;
		for(int i=1; i<=n; i++) {
			int k=sc.nextInt();
			dp[k]=dp[k-1]+1;
			max=Math.max(dp[k], max);
		}
		
		System.out.println(n-max);
	}
	
}
