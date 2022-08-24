import java.io.*;
import java.util.*;


public class Main {		
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String a= sc.next();
		String b= sc.next();
		String c= sc.next();
		
		int len1=a.length();
		int len2=b.length();
		int len3=c.length();
		
		int dp[][][]=new int[len1+1][len2+1][len3+1];
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				for(int k=1; k<=len3; k++) {
					if(a.charAt(i-1)==b.charAt(j-1) && b.charAt(j-1)==c.charAt(k-1))
						dp[i][j][k]=dp[i-1][j-1][k-1]+1;
					else
						dp[i][j][k]=Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
				}
			}
		}
		System.out.println(dp[len1][len2][len3]);

	}
}
