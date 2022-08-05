import java.util.*;
import java.io.*;


public class Main {

	static int n, m;
	static int map[][];
	static int tmp[][];
	static int max=0;
	static int dx[]= {0,1,0,-1};
	static int dy[]= {1,0,-1,0};
	
	public static void count() {
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(tmp[i][j] == 0) sum++;
			}
		}
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(tmp[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		max=Math.max(max, sum);
	}
	
	public static void spread(int x, int y) {
		for(int dir=0; dir<4; dir++) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			if(nx<0 || ny< 0 || nx>=n || ny>=m) continue;
			if(tmp[nx][ny]!=0) continue;
			tmp[nx][ny]=2;
			spread(nx, ny);
		}

	}
	
	public static void dfs(int count) {
		if(count==3) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					tmp[i][j]=map[i][j];
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(tmp[i][j]==2)
						spread(i, j);
				}
			}
			
			count();
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					count++;
					dfs(count);
					map[i][j]=0;
					count--;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		n=sc.nextInt(); m=sc.nextInt();
		map=new int[n][m];
		tmp=new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		dfs(0);
		System.out.println(max);
		
	}
	
}
