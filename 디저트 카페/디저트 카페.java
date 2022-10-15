import java.util.*;
import java.io.*;

class Solution {

	static int n;
	static int map[][];
	static boolean desert[] = new boolean[101];
	static int dx[]= {-1,-1,1,1};
	static int dy[]= {-1,1,1,-1};
	static int max = -1;
	
	public static void DFS(int sx, int sy, int x, int y, int dir, int turn) {
		if(turn == 4) {
			if(x==sx && y==sy) {
                int sum=0;
				for(int i=0; i<101; i++)
					if(desert[i])
						sum++;
				
				max = Math.max(max, sum);
				
			}
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx < 0 || ny< 0 || nx >= n || ny>=n) continue;
			if(desert[map[nx][ny]]) continue;
			
			desert[map[nx][ny]] = true;
			if(dir == d)
				DFS(sx, sy, nx, ny, d, turn);
			else
				DFS(sx, sy, nx, ny, d, turn+1);
 			desert[map[nx][ny]] =  false;
		}
	}
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			map = new int[n][n];
			
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					map[i][j] = sc.nextInt();
			
			max = -1;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					desert = new boolean[101];
					
					for(int k=2; k<4; k++)
						DFS(i, j, i, j, k, 0);
				}
			}

			System.out.println("#"+test_case+" "+(max != 0 ? max : -1));
		}
	}
}
