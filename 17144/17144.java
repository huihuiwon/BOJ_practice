import java.util.*;
import java.io.*;

class Main {

	static int n, m, t;
	static int [][] map, tmp;
	static int dx[]= {1,0,-1,0};
	static int dy[]= {0,1,0,-1};
	static int air1=-1, air2;
	static Queue<int[]> q = new LinkedList<>();
	public static void spread() {
		tmp = new int[n][m];
		while(!q.isEmpty()) {
			int cur [] =q.poll();
			int cnt = 0; int amount = map[cur[0]][cur[1]]/5;
			for(int dir=0; dir<4; dir++) {
				int nx = cur[0]+dx[dir];
				int ny = cur[1]+dy[dir];
				if(nx< 0 || ny< 0 || nx>= n || ny>=m) continue;
				if(map[nx][ny] == -1) continue;

				tmp[nx][ny] += amount;
				cnt++;
			}
			tmp[cur[0]][cur[1]] += map[cur[0]][cur[1]] - amount*cnt;
		}
		
		
		tmp[air1][0] = -1;
		tmp[air2][0] = -1;
	
	}
	
	public static void fresh() {
		//반시계
		for(int i= air1-1; i>0; i--) // 왼
			tmp[i][0] = tmp[i-1][0];
		
		for(int i=0; i<m-1; i++)  // 위
			tmp[0][i] = tmp[0][i+1];
		
		for(int i=1; i<=air1; i++)  // 오
			tmp[i-1][m-1] = tmp[i][m-1];
		
		for(int i=m-1; i>1; i--)  // 아
			tmp[air1][i] = tmp[air1][i-1];
		tmp[air1][1] = 0;
		
		for(int i=air2+1; i<n-1; i++)
			tmp[i][0] = tmp[i+1][0];
		
		for(int i=0; i<m-1; i++)
			tmp[n-1][i] = tmp[n-1][i+1];
		
		for(int i=n-1; i>=air2; i--)
			tmp[i][m-1] = tmp[i-1][m-1];
		
		for(int i=m-1; i>1; i--)
			tmp[air2][i] = tmp[air2][i-1];
		tmp[air2][1] = 0;

	}
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt(); t = sc.nextInt();
		map = new int[n][m];
		tmp = new int[n][m];

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j]= sc.nextInt();
				if(map[i][j] > 0) q.add(new int[] {i, j});
				if(map[i][j] == -1) {
					if(air1 == -1) {
						air1 = i;
					}
					else
						air2 = i;
				}
			}
		}
    
		for(int index=0; index<t; index++) {
			spread();
			fresh();
			
			q = new LinkedList<>();
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					map[i][j] = tmp[i][j];
					if(map[i][j] > 0) q.add(new int[] {i, j});
				}
			}
		}
		
		
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] > 0)
					sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
}
