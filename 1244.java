import java.util.*;
import java.io.*;


public class Main {


	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s[]=new int[n+1];
		for(int i=1; i<=n; i++)
			s[i]=sc.nextInt();
		
		int m=sc.nextInt();
		for(int i=0; i<m; i++) {
			int sex=sc.nextInt(); int cnt=sc.nextInt();
			if(sex==1) {
				for(int j=cnt; j<=n; j+=cnt) {
					if(s[j]==0) s[j]=1;
					else s[j]=0;
				}
			}
			else {
				int index = Math.min(n-cnt, cnt-1);
				if(s[cnt]==0) s[cnt]=1;
				else s[cnt]=0;
				
				for(int j=1; j<=index; j++) {
					if(s[cnt-j] == s[cnt+j]) {
						if(s[cnt-j]==0) {
							s[cnt-j]=1;
							s[cnt+j]=1;
						}
						else {
							s[cnt-j]=0;
							s[cnt+j]=0;
						}
					}
					else
						break;
				}
			}
			
		}

		for(int j=1; j<=n; j++) {
			System.out.print(s[j]+" ");
			if(j % 20==0 )System.out.println();
		}
	}
	
}
