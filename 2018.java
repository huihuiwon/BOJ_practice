import java.util.*;
import java.io.*;


public class Main {	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans=1;
		if(n==1) {   // N이 1일 때 예외처리 필요
			System.out.println(ans);
			return;
		}

		for(int i = n/2+n%2; i>=1; i--) {
			int sum = 0;
			for(int j=i; j>=1; j--) {
				sum += j;
				if(sum == n) {
					ans++;
				}
				if(sum >= n)
					break;
			}
		}
		
		System.out.println(ans);
	}
	
}
