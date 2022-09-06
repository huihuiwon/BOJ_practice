import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int w = sc.nextInt(); int h=sc.nextInt();
			if(w== 0 && h==0) return;
			int map[][]=new int[h][w];
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++)
					map[i][j]=sc.nextInt();
			}
			
			int dx[]= {0,1,0,-1,1,1,-1,-1};
			int dy[]= {1,0,-1,0,1,-1,1,-1};
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
						for(int dir=0; dir<8; dir++) {
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
			System.out.println(cnt);
		}
	}
}
