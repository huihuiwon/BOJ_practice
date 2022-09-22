import java.util.*;
import java.io.*;


public class Main {	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp[] = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		
		char map[][]=new char[n][m];
		int water[][]=new int[n][m];
		int dist[][]=new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				water[i][j]=-1;
				dist[i][j]=-1;
			}
		}
		
		Queue<int[]> w = new LinkedList<>();
		Queue<int[]> d = new LinkedList<>();


		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='S') {
					d.add(new int[] {i, j});
					dist[i][j]=0;
				}
				else if(map[i][j]=='*') {
					w.add(new int[] {i, j});
					water[i][j]=0;
				}
			}
		}
		
		int dx[]= {0,1,0,-1};
		int dy[]= {1,0,-1,0};
		while(!w.isEmpty()) {
			int cur[]=w.poll();
			for(int dir=0; dir<4; dir++) {
				int nx = dx[dir]+cur[0];
				int ny = dy[dir]+cur[1];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
				if(water[nx][ny] != -1 || map[nx][ny]=='D' || map[nx][ny]=='X') continue;
				w.add(new int[] {nx, ny});
				water[nx][ny] = water[cur[0]][cur[1]]+1;
			}
		}
		
		while(!d.isEmpty()) {
			int cur[]=d.poll();
			for(int dir=0; dir<4; dir++) {
				int nx = dx[dir]+cur[0];
				int ny = dy[dir]+cur[1];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
				if(dist[nx][ny] != -1 || map[nx][ny]=='*' || map[nx][ny]=='X') continue;
				if(dist[cur[0]][cur[1]]+1 >= water[nx][ny] && map[nx][ny] != 'D' && water[nx][ny]!=-1) continue;
				d.add(new int[] {nx, ny});
				dist[nx][ny] = dist[cur[0]][cur[1]]+1;
				
				if(map[nx][ny]=='D') {
					System.out.println(dist[nx][ny]);
					return;
				}
			}
		}
		
		
		System.out.println("KAKTUS");
	}
	
}
