import java.io.*;
import java.util.*;

public class Main {

	static int h, w;
	static int[][] map;
	static int dx[]= {0,1,0,-1};
	static int dy[]= {1,0,-1,0};
	public static int count() {
		
		boolean chk[][]=new boolean[h][w];
		int cnt=0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(chk[i][j] || map[i][j]==0) continue;
				cnt++;
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[] {i, j});
				chk[i][j]=true;
				while(!q.isEmpty()) {
					int cur[]=q.poll();
					for(int dir=0; dir<4; dir++) {
						int nx=dx[dir]+cur[0];
						int ny=dy[dir]+cur[1];
						if(nx<0 || nx>=h || ny<0 || ny>=w) continue;
						if(chk[nx][ny] || map[nx][ny]==0) continue;
						chk[nx][ny]=true;
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
		
		return cnt;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt(); w=sc.nextInt();
		map=new int[h][w];
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++)
				map[i][j]=sc.nextInt();
		}
		
		int ans=0;
		if(count() >= 2) {
			System.out.println(ans);
			return;
		}
		
		while(true) {
			ans++;
			Queue<int[]> q = new LinkedList<>();
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] != 0) {
						q.add(new int[] {i, j});
					}
				}
			}
			
			if(q.size()==0) {
				System.out.println(0);
				return;
			}
			
			boolean now[][]=new boolean[h][w];
			while(!q.isEmpty()) {
				int cur[]=q.poll();
				int z_cnt=0;
				for(int dir=0; dir<4; dir++) {
					int nx=dx[dir]+cur[0];
					int ny=dy[dir]+cur[1];
					if(nx<0 || nx>=h || ny<0 || ny>=w) continue;
					if(map[nx][ny]==0 && !now[nx][ny]) z_cnt++;
				}
				map[cur[0]][cur[1]] -= z_cnt;
				if(map[cur[0]][cur[1]] < 0) map[cur[0]][cur[1]]=0;
				now[cur[0]][cur[1]]=true;
			}
			
			if(count() >= 2) {
				System.out.println(ans);
				return;
			}
	
		}
	}
}
