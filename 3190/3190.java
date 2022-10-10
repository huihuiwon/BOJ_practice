import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;
import java.io.FileInputStream;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		
		int map[][]= new int[n+2][n+2];
		for(int i=0; i<=n; i++) {
			map[i][0]=2; map[0][i]=2;
			map[n+1][i]=2; map[i][n+1]=2;
		}
		
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k ;i++) {
			String tmp [] = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]); int b = Integer.parseInt(tmp[1]);
			map[a][b]=1;
		}
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] {1, 1, 1});
		map[1][1]=2;
		
		int dx[]= {-1,0,1,0};
		int dy[]= {0,1,0,-1};
		
		int l = Integer.parseInt(br.readLine());
		for(int i=0; i<l; i++) {
			String tmp [] = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]); int b = tmp[1].charAt(0);
			
			while(ans!=a) {
				ans++;
				
				int cur[] = dq.peekLast();  // 현재 머리
				int nx = cur[0]+dx[cur[2]]; int ny = cur[1]+dy[cur[2]];
				
				if(map[nx][ny]==2) {
					System.out.println(ans);
					return;
				}
				
				dq.addLast(new int[] {nx, ny, cur[2]});
				if(map[nx][ny] != 1) {
					int tmp_remove[] = dq.pollFirst();  // 꼬리
					map[tmp_remove[0]][tmp_remove[1]]=0;
				}
				map[nx][ny]=2;
			}
			
			int cur[] = dq.peekLast();
			int head[] = dq.pollLast();
			if(cur[2]==0) {
				if(b=='L') dq.addLast(new int[] {head[0], head[1], 3});
				else dq.addLast(new int[] {head[0], head[1], 1});
			}
			else if(cur[2]==1) {
				if(b=='L') dq.addLast(new int[] {head[0], head[1], 0});
				else dq.addLast(new int[] {head[0], head[1], 2});
			}
			else if(cur[2]==2) {
				if(b=='L') dq.addLast(new int[] {head[0], head[1], 1});
				else dq.addLast(new int[] {head[0], head[1], 3});
			}
			else {
				if(b=='L') dq.addLast(new int[] {head[0], head[1], 2});
				else dq.addLast(new int[] {head[0], head[1], 0});
			}
		}
		
		
		while(true) {
			ans++;
			
			int cur[] = dq.peekLast();  // 현재 머리
			int nx = cur[0]+dx[cur[2]]; int ny = cur[1]+dy[cur[2]];
			
			if(map[nx][ny]==2) {
				System.out.println(ans);
				return;
			}
			
			dq.addLast(new int[] {nx, ny, cur[2]});
			if(map[nx][ny] != 1) {
				int tmp_remove[] = dq.pollFirst();  // 꼬리
				map[tmp_remove[0]][tmp_remove[1]]=0;
			}
			map[nx][ny]=2;
		}
	}
}
