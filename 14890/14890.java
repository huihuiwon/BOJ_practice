import java.util.*;
import java.io.*;

class Main {

	static int n, m;
	static int map[][];
	public static void main(String args[]) throws Exception	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String tmp[] = br.readLine().split(" ");
		
		n = Integer.parseInt(tmp[0]); m = Integer.parseInt(tmp[1]); 
		map=new int[n][n];
		
		for(int i=0; i<n; i++) {
			tmp = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		int ans = 0;
		
		boolean chk[][]=new boolean[n][n];
		for(int i=0; i<n; i++) {
			boolean flag = true;
			for(int j=0; j<n-1; j++) {
				if(map[i][j] == map[i][j+1]) continue;
				if(Math.abs(map[i][j]-map[i][j+1]) > 1) {
					flag = false;
					break;
				}
				if(map[i][j] < map[i][j+1]) {
					if(j-m+1 < 0) {
						flag= false;
						break;
					}
					int basic = map[i][j];
					for(int k=j; k>j-m; k--) {
						if(k<0 || map[i][k] != basic || chk[i][k]) {
							flag = false;
							break;
						}
						if(k>=0) chk[i][k]=true;
					}
				}
				else {
					int basic = map[i][j+1];
					for(int k=j+1; k<=j+m; k++) {
						if(k >= n || map[i][k] != basic || chk[i][k]) {
							flag = false;
							break;
						}
						if(k< n) chk[i][k]= true;
					}
					if(flag) j += (m-1);
				}
			//	System.out.println(flag+" "+j);
			}
			
			if(flag) {
				ans++;
			}
		}
		
		chk = new boolean[n][n];
		for(int j=0; j<n; j++) {
			boolean flag = true;
			for(int i=0; i<n-1; i++) {
		//		System.out.println("i"+i);
				if(map[i][j] == map[i+1][j]) continue;
				if(Math.abs(map[i][j]-map[i+1][j]) > 1) {
					flag = false;
					break;
				}
				if(map[i][j] < map[i+1][j]) {
					if(i-m+1 < 0) {
						flag= false;
						break;
					}
					
					int basic = map[i][j];
					for(int k=i; k>i-m; k--) {
						if(k<0 || map[k][j] != basic || chk[k][j]) {
							flag = false;
							break;
						}
						if(k>=0) chk[k][j]=true;
					}
				}
				else {
					int basic = map[i+1][j];
		//			System.out.println("basic"+basic+" "+i);
					for(int k=i+1; k<=i+m; k++) {
					//	System.out.println(i+m);
						if(k >= n || map[k][j] != basic || chk[k][j]) {
							flag = false;
							break;
						}
						if(k<n) chk[k][j] = true;
					}
					if(flag)
						i += (m-1);
				}
			}
			
			if(flag) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
