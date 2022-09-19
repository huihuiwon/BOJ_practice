import java.util.*;
import java.io.*;


public class Main {	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int m=sc.nextInt();
		int map[][]=new int[n][m];

		int cheese=0;
		for(int i=0; i<n;i ++) {
			for(int j=0; j<m; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==1) cheese++;
			}
		}
		
		
		
		int dx[]= {0,1,0,-1};
		int dy[]= {1,0,-1,0};
		int result = 0; int tmp=0;
		while(true) {
			boolean visit[][]=new boolean[n][m];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int [] {0, 0});
			visit[0][0]=true;
			
			if(cheese==0) {
				System.out.println(result);
				System.out.println(tmp);
				return;
			}
			result++;
			
			tmp = 0;
			while(!q.isEmpty()) {
				int cur[]= q.poll();
				for(int dir=0 ;dir<4; dir++) {
					int nx = cur[0]+dx[dir];
					int ny = cur[1]+dy[dir];
					
					if(nx< 0|| ny<0|| nx>=n || ny>=m) continue;
					if(visit[nx][ny]) continue;
					
					if(map[nx][ny]==1) {
						map[nx][ny]=0;
						cheese--;
						tmp++;
					}
					else q.add(new int[] {nx, ny});
					
					visit[nx][ny]=true;
				}
			}
		}
	}
	
}
