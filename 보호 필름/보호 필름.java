import java.util.*;
import java.io.*;

class Solution {

	static int n, m, k;
	static int map[][];
	static int tmp[][];
	static int ans = 100;
	
	static boolean chk(int[][] tmp_map) {
		for(int i=0; i<m; i++) {
			int cnt = 1;
			for(int j=1; j<n; j++) {
				if(cnt >= k) break;
				if(tmp_map[j-1][i] == tmp_map[j][i]) cnt++;
				else {
					cnt = 1;
				}		
			}
			if(cnt < k) {
				return false;
			}
		}
		return true;
	}
	
	
	static void DFS(int cnt, int L) {
		if(cnt >= ans) return;
		if(L == n) {
			if(chk(tmp)) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		DFS(cnt, L+1);
		
		for(int i=0; i<m; i++)
			tmp[L][i] = 0;
		DFS(cnt+1, L+1);
		
		for(int i=0; i<m; i++)
			tmp[L][i] = 1;
		DFS(cnt+1, L+1);
		
		for(int i=0; i<m; i++)
			tmp[L][i] = map[L][i];
	}
	
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
			map = new int[n][m];
			tmp = new int[n][m];
			
			for(int i=0; i<n; i++) {
				for(int j=0 ; j <m; j++){
					map[i][j] = sc.nextInt();
                	tmp[i][j] = map[i][j];
                }
			}
			
			ans = 100;
			if(k==1 || chk(map)) {
				System.out.println("#"+test_case+" "+0);
			}
			else{
                DFS(0, 0);
                System.out.println("#"+test_case+" "+ans);
            }
		}
	}
}
