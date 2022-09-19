import java.util.*;
import java.io.*;


public class Main {	

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int l = sc.nextInt(); int r = sc.nextInt();
		int map[][]=new int[n][n];

		for(int i=0; i<n;i ++) {
			for(int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		int dx[]= {0,1,0,-1};
		int dy[]= {1,0,-1,0};
		
		int result=0;
		while(true) {
			boolean flag = false;
			boolean visit[][]=new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(visit[i][j]) continue;
					
					Queue<int[]> q= new LinkedList<>();
					q.add(new int[] {i, j});
					visit[i][j]= true;
					
					int count=1; int sum=map[i][j];
					ArrayList<int[]> arr =new ArrayList<>();
					while(!q.isEmpty()) {
						int cur[]= q.poll();
						for(int dir=0; dir<4; dir++) {
							int nx= cur[0]+dx[dir];
							int ny= cur[1]+dy[dir];
							
							if(nx<0 || ny<0 || nx>= n|| ny>=n) continue;
							if(visit[nx][ny]) continue;
							int diff = Math.abs(map[nx][ny]-map[cur[0]][cur[1]]);
							if(diff < l || diff > r) continue;
							
							count++;
							sum += map[nx][ny];
							q.add(new int[] {nx, ny});
							visit[nx][ny]=true;
							arr.add(new int[] {nx, ny});
						}
					}
					int tmp = sum/count;
					for(int a[] : arr) {
						map[a[0]][a[1]]=tmp;
					}
					if(count!=1) {
						map[i][j]=tmp;
						flag=true;
					}
				}
			}
			if(!flag) break;
			result++;
		}
		
		System.out.println(result);
		
	}
	
}
