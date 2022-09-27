import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int map[][]=new int[n][n];
    	for(int i=0; i<n; i++) {
    		String str = br.readLine();
    		for(int j=0; j<n; j++) {
    			map[i][j]=str.charAt(j)-'0';
    		}
    	}
    	
    	boolean visit[][][]=new boolean[n][n][101];
    	visit[0][0][0]=true;
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {0, 0, 0});
    	
    	
    	int dx[]= {0,1,0,-1};
    	int dy[]= {1,0,-1,0};
    	int min = 101;
    	while(!q.isEmpty()) {
    		int cur[] = q.poll();
    		for(int dir=0; dir<4; dir++) {
    			int nx = cur[0]+dx[dir];
    			int ny = cur[1]+dy[dir];
    			
    			if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
    			if(nx==n-1 && ny==n-1){
    				min = Math.min(cur[2], min);
    				break;
    			}
    			if(cur[2] >= n+n) continue;
    			if(map[nx][ny] == 1) {
    				if(visit[nx][ny][cur[2]]) continue;
    				q.add(new int[] {nx, ny, cur[2]});
    				visit[nx][ny][cur[2]] = true;
    			}
    			else {
    				if(visit[nx][ny][cur[2]+1]) continue;
    				q.add(new int[] {nx, ny, cur[2]+1});
    				visit[nx][ny][cur[2]+1] = true;
    			}
    		}
    	}
    	System.out.println(min);
    }
}
