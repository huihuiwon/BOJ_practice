import java.util.*;
import java.io.*;


class Node {
	int data;
	Node lt, rt;
	public Node(int val) {
		data=val;
		lt=rt=null;
	}
}
public class Main {	
	
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int dx[]= {0,1,0,-1};
		int dy[]= {1,0,-1,0};
		while(tc-->0) {
			int n=sc.nextInt(); int m=sc.nextInt(); int o=sc.nextInt(); int f=sc.nextInt(); 
			int sx = sc.nextInt(); int sy = sc.nextInt(); int ex=sc.nextInt(); int ey = sc.nextInt();
			
			int map[][]=new int[n+1][m+1];
			int dist[][]=new int[n+1][m+1];
			Queue<int[]> q = new LinkedList<>();
			dist[sx][sy]=f;
			q.add(new int[] {sx, sy});
			
			for(int i=0; i<o; i++) {
				int a = sc.nextInt(); int b =sc.nextInt(); int c = sc.nextInt();
				map[a][b]=c;
			}
			
			boolean flag = true;
			while(!q.isEmpty()) {
				int cur[]=q.poll();
				if(!flag) break;
				if(dist[cur[0]][cur[1]] <= 0) continue;
				if(cur[0]==ex && cur[1]==ey) {
					System.out.println("잘했어!!");
					flag=true;
					break;
				}
				
				for(int dir=0; dir<4; dir++) {
					int nx= dx[dir]+cur[0];
					int ny= dy[dir]+cur[1];
					
					if(nx== ex&& ny==ey) {
						System.out.println("잘했어!!");
						flag = false;
						break;
					}
					
					if(nx<1 || ny<1 || nx>n || ny>m) continue;
					if(dist[nx][ny] != 0) continue;
					if(dist[cur[0]][cur[1]] < map[nx][ny]-map[cur[0]][cur[1]]) continue;
					
					
					
					q.add(new int[] {nx, ny});
					dist[nx][ny]=dist[cur[0]][cur[1]]-1;

				}
			}
			
			if(flag)
				System.out.println("인성 문제있어??");
		}
	}
}
