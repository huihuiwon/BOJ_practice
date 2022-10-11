import java.util.*;
import java.io.*;

class Main {
	
	static int n, m;
	static int dx[]= {-1,0,1,0};
	static int dy[]= {0,1,0,-1};
	static int[][] map;
	static boolean[][] clean;
	static int ans=1;
	
	public static void DFS(int x, int y, int d) {
		for(int dir = 0; dir<4; dir++) {
			int nd = (d+3-dir) % 4;
			int nx = x+dx[nd];
			int ny = y+dy[nd];
			
			if(nx < 0|| ny< 0|| nx>=n || ny>=m) continue;
			if(map[nx][ny]==1 || clean[nx][ny]) continue;
			clean[nx][ny]=true;
			ans++;
			DFS(nx, ny, nd);
			return;
		}
		
		int bd = (d+2)%4;
		int bx = x+dx[bd];
		int by = y+dy[bd];
		
		if(bx>=0 && by>=0 && bx<n && by<m) {
			if(map[bx][by] == 0) {
				DFS(bx, by, d);
			}
		}
	}
	
	public static void main(String args[]) throws Exception	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String tmp[] = br.readLine().split(" ");
		
		n = Integer.parseInt(tmp[0]); m = Integer.parseInt(tmp[1]); 
		map=new int[n][m];
		clean = new boolean[n][m];
		
		tmp = br.readLine().split(" ");
		int r = Integer.parseInt(tmp[0]);
		int c = Integer.parseInt(tmp[1]);
		int d = Integer.parseInt(tmp[2]);
		
		for(int i=0; i<n; i++) {
			tmp = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		clean[r][c]=true;
		DFS(r, c, d);
		
		System.out.println(ans);
		
	}
}
