import java.util.*;
import java.io.*;

class Main {
	
	static int n, m;
	static int map[][];
	static int dx[]= {0,1,0,-1};
	static int dy[]= {1,0,-1,0};
	static int ans = 0;
	static boolean[][] visit;
	static int sx, sy;


	public static void count(int L, int x, int y, int sum) {
		if(L==4) {
			ans = Math.max(ans, sum);
			return;
		}

		for(int dir=0; dir<4; dir++) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			
			if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			if(visit[nx][ny]) continue;
			
			if(L==2) {
				visit[nx][ny]=true;
				count(L+1, x, y, sum+map[nx][ny]);
				visit[nx][ny]=false;
			}
			
			visit[nx][ny]=true;
			count(L+1, nx, ny, sum+map[nx][ny]);			
			visit[nx][ny]=false;
			

		}
		
//		System.out.println("---"+x+" "+y);
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(visit[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("!!");
//		

	}
	public static void main(String args[]) throws Exception	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String tmp[] = br.readLine().split(" ");
		
		n = Integer.parseInt(tmp[0]); m = Integer.parseInt(tmp[1]); 
		map=new int[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; i++) {
			tmp = br.readLine().split(" ");
			for(int j=0; j<m; j++)
				map[i][j] = Integer.parseInt(tmp[j]);
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visit[i][j]=true;

				count(1, i, j, map[i][j]);
				visit[i][j]=false;
			}
		}
		
		System.out.println(ans);
		
	}
}
