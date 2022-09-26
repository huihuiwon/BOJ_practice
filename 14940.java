import java.util.*;
import java.io.*;


public class Main {	

	static ArrayList<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int m = sc.nextInt();
		int map[][]=new int[n][m];
		Queue<int[] >q = new LinkedList<>();
		int dist[][]=new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++)
				dist[i][j]=-1;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==2) {
					q.add(new int[] {i, j});
					dist[i][j]=0;
				}
				else if(map[i][j]==0)
					dist[i][j]=0;
			}
		}
		
		int dx[]= {0,1,0,-1};
		int dy[]= {1,0,-1,0};
		while(!q.isEmpty()) {
			int cur[]=q.poll();
			for(int dir=0; dir<4; dir++) {
				int nx=cur[0]+dx[dir];
				int ny=cur[1]+dy[dir];
				if(nx<0 || ny<0|| nx>=n || ny>=m) continue;
				if(map[nx][ny]!=1 || dist[nx][ny] != -1) continue;
				dist[nx][ny]=dist[cur[0]][cur[1]]+1;
				q.add(new int[] {nx, ny});
			}
		}
    
		StringBuilder sb = new StringBuilder();  // System.out.println() 을 쓰니 시간 초과
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sb.append(dist[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}
