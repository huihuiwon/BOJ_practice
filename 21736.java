import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); int m=sc.nextInt();
		char map[][]=new char[n][m];
		sc.nextLine();
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			String str = sc.nextLine();
			for(int j=0; j<m; j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='I') {
					q.add(new int[] {i, j});
				}
			}
		}
		
		boolean chk[][]=new boolean[n][m];
		int ans=0;
		int dx[]= {0,1,0,-1};
		int dy[]= {1,0,-1,0};
		while(!q.isEmpty()) {
			int cur[]=q.poll();
			for(int dir=0; dir<4; dir++) {
				int nx=dx[dir]+cur[0];
				int ny=dy[dir]+cur[1];
				if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
				if(chk[nx][ny] || map[nx][ny]=='X') continue;
				if(map[nx][ny]=='P') ans++;
				q.add(new int[] {nx, ny});
				chk[nx][ny]=true;
			}
		}
		
		if(ans==0)
			System.out.println("TT");
		else
			System.out.println(ans);
		
	}
}
