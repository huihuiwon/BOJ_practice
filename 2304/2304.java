import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int mx=0; int my=0; int my_i=0;
		int arr[]=new int[1001];
		for(int i=0; i<n; i++) {
			int a=sc.nextInt(); int b=sc.nextInt();
			if(b > my) {
				my=b;
				my_i=a;
			}
			mx=Math.max(mx, a);
			arr[a]=b;
		}
		
		
		int ans=0; int cur=0;
		for(int i=0; i<=my_i; i++) {
			cur=Math.max(cur, arr[i]);
			ans += cur;
		}
		cur=0;
		for(int i=mx; i>my_i; i--) {
			cur=Math.max(cur, arr[i]);
			ans += cur;
		}
		
		System.out.println(ans);
	}
}
