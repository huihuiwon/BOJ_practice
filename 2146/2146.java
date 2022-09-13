import java.util.*;
import java.io.*;


public class Main {	

	static int dx[]= {0,1,0,-1};
	static int dy[]= {1,0,-1,0};
	static int min = Integer.MAX_VALUE;
	static int chk[][];
	
	public static void make(int[][] map, int n, int i, int j, int[][] dist, int gn) {
		Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        dist[i][j]=0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int idx = 0; idx < 4; idx++)  {
                int mx = cur[0] + dx[idx];
                int my = cur[1]+ dy[idx];

                if(mx<0 || my<0 || mx>=n || my>=n || map[mx][my] == gn || dist[mx][my]!=-1) continue;
                if(map[mx][my] == 0)  {
                    dist[mx][my] = dist[cur[0]][cur[1]]+1;
                    q.add(new int[] {mx,my});
                }
                else if(map[mx][my] == 1 && chk[mx][my] != chk[i][j]){
                	min = Math.min(min,dist[cur[0]][cur[1]]);
                }
                
            }
        }	
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int map[][]=new int[n][n];
		chk=new int[n][n];

		for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			map[i][j]=sc.nextInt();
    		}
    	}

		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(chk[i][j]!=0 || map[i][j]==0) continue;
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[] {i, j});
				cnt++;
				chk[i][j]= cnt;
				
				while(!q.isEmpty()) {
					int cur[]=q.poll();
					for(int dir=0; dir<4; dir++) {
						int nx=dx[dir]+cur[0];
						int ny=dy[dir]+cur[1];
						if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
						if(map[nx][ny]==0 || chk[nx][ny]!=0) continue;
						q.add(new int[] {nx, ny});
						chk[nx][ny]=cnt;
					}
				}
			}
		}
		
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int dist[][]=new int[n][n];
				for(int k=0; k<n; k++)
					Arrays.fill(dist[k], -1);
				
				if(dist[i][j]!=-1 || map[i][j]==0) continue;
				make(map, n, i, j, dist, chk[i][j]);
			}
		}

		System.out.println(min);
	}
	
}
