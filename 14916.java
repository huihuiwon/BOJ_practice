import java.util.*;
import java.io.*;


public class Main {
	public static int min(int a, int b, int c) {
		int min=Math.min(a, b);
		min=Math.min(min, c);
		return min;
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int result=0;
		int dp[] = new int[100001];   //new int[n+1] 로 해버리면 n이 1~4일 때 오류 발생 (밑에서 dp[2]=1, dp[5]=1 해서)
		Arrays.fill(dp, 100001);   // n은 최대 100,000. 따라서 가능한 최댓값은 50,000 -> 최소 50,000 이상 수로 초기화해야함
		dp[2]=1; dp[5]=1;
		for(int i=3; i<=n; i++) {
			if(i<5)
				dp[i]=Math.min(dp[i], dp[i-2]+1);
			else {
				dp[i]=min(dp[i], dp[i-2]+1, dp[i-5]+1);
			}
		}
		
		if(dp[n] != 100001)
			System.out.println(dp[n]);
		else
			System.out.println(-1);
	}
	
}
