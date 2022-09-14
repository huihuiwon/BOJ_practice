import java.util.*;
import java.io.*;


public class Main {	

	static int n, m, g, r;
	static boolean chk[];
	static int map[][];
	static int cnt=0;
	static int green[];
	static int red[];
	static ArrayList<int[]> al;
	static int max=0;
	
	public static void order(int L, int s) {
		if(L==g) {
			order_red(0, 0);
			return;
		}
		
		for(int i=s; i<cnt; i++) {
			if(chk[i]) continue;
			chk[i]=true;
			green[L]=i;
			order(L+1, i+1);
			chk[i]=false;
		}
	}
	
	public static void order_red(int L, int s) {
		if(L==r) {
			bfs();
			return;
		}
		
		for(int i=s; i<cnt; i++) {
			if(chk[i]) continue;
			chk[i]=true;
			red[L]=i;
			order_red(L+1, i+1);
			chk[i]=false;
		}
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int g_dist[][]= new int[n][m];
		int r_dist[][]= new int[n][m];
		int dist[][]=new int[n][m];
		
		for(int i=0; i<g; i++) {
			int gx[]=al.get(green[i]);
			g_dist[gx[0]][gx[1]]=1;
			dist[gx[0]][gx[1]]=1;
			q.add(new int[] {gx[0], gx[1]});
		}
		for(int i=0; i<r; i++) {
			int rx[]=al.get(red[i]);
			r_dist[rx[0]][rx[1]]=1;
			dist[rx[0]][rx[1]]=2;
			q.add(new int[] {rx[0], rx[1]});
		}
		
		int dx[]= {0,1,0,-1};
		int dy[]= {1,0,-1,0};
		
		
		int count=0;
		while(!q.isEmpty()) {
			int cur[]=q.poll();
			if(dist[cur[0]][cur[1]] == 3) continue;
			for(int dir=0; dir<4; dir++) {
				int nx= cur[0]+dx[dir];
				int ny= cur[1]+dy[dir];
				if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
				if(map[nx][ny]==0) continue;
				
				if(dist[nx][ny]==0) {
					dist[nx][ny] = dist[cur[0]][cur[1]];
					q.add(new int[] {nx, ny});
					if(dist[cur[0]][cur[1]]==1) g_dist[nx][ny]=g_dist[cur[0]][cur[1]]+1;
					else r_dist[nx][ny]=r_dist[cur[0]][cur[1]]+1;
				}
				else if(dist[nx][ny]==1) { //그린
					if(dist[cur[0]][cur[1]]==2 && r_dist[cur[0]][cur[1]]+1==g_dist[nx][ny]) {
						count++;
						dist[nx][ny]=3;
					}
				}
				else {
					if(dist[cur[0]][cur[1]]==1 && g_dist[cur[0]][cur[1]]+1==r_dist[nx][ny]) {
						count++;
						dist[nx][ny]=3;
					}
				}
				
			}
		}
		
		max = Math.max(max, count);
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		g = sc.nextInt(); r = sc.nextInt();
		
		map = new int[n][m];
		green = new int[g];
		red = new int[r];
		
		al = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j] == 2) {
					al.add(new int[] {i, j});
					cnt++;
				}
			}
		}
		
		chk = new boolean[cnt];
		
		order(0, 0);
		
		System.out.println(max);
	}
	
}
