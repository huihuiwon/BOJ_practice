import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.io.FileInputStream;


class Solution {
	static int n, m, r, c, l;
    static int dx[]= {-1,0,1,0};
    static int dy[]= {0,1,0,-1};
    static int[][] map;
    static int[][] dist;
    static Queue<int[]> q;
    static boolean flag=false;
	public static void move(int[] cur, int dir) {
		int nx = cur[0]+dx[dir];
		int ny = cur[1]+dy[dir];
	//	System.out.println(nx+" "+ny);
		if(nx<0 || ny<0 || nx>=n || ny>=m) return;
		//System.out.println(cur[0]+":"+cur[1]+" "+nx+":"+ny+"-"+dir+" "+map[nx][ny]);
		if(dir==0 && (map[nx][ny]==3 || map[nx][ny]==4 || map[nx][ny]==7)) return;
		if(dir==1 && (map[nx][ny]==2 || map[nx][ny]==4 || map[nx][ny]==5)) return;
		if(dir==2 && (map[nx][ny]==3 || map[nx][ny]==5 || map[nx][ny]==6)) return;
		if(dir==3 && (map[nx][ny]==2 || map[nx][ny]==6 || map[nx][ny]==7)) return;
		if(map[nx][ny] == 0 || dist[nx][ny] != 0) return;
		
		
		q.add(new int[] {nx, ny, map[nx][ny]});
		dist[nx][ny] = dist[cur[0]][cur[1]]+1;
//		if(dist[nx][ny]>=l) flag=true;
	}
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)		{
			n = sc.nextInt(); m = sc.nextInt();
			r = sc.nextInt(); c = sc.nextInt(); l = sc.nextInt();
			
            map = new int[n][m];
            dist = new int[n][m];
            for(int i=0; i<n; i++){
            	for(int j=0; j<m; j++){
                	map[i][j] = sc.nextInt();
                }
            }

            q = new LinkedList<>();
            q.add(new int[] {r, c, map[r][c]});
            dist[r][c]=1;
            
            if(l==1) {
                System.out.println("#"+test_case+" "+1);
                continue;
            }
            

            flag = false;
            while(!q.isEmpty()) {
            	int cur[] = q.poll();
//            	System.out.println(cur[0]+" "+cur[1]+" "+cur[2]);
            	if(cur[2]==1) {
            		move(cur, 0);
            		move(cur, 1);
            		move(cur, 2);
            		move(cur, 3);
            	}
            	else if(cur[2]==2) {
            		move(cur, 0);
            		move(cur, 2);
            	}
            	else if(cur[2]==3) {
            		move(cur, 1);
            		move(cur, 3);
            	}
            	else if(cur[2]==4) {
            		move(cur, 0);
            		move(cur, 1);
            	}
            	else if(cur[2]==5) {
            		move(cur, 1);
            		move(cur, 2);
            	}
            	else if(cur[2]==6) {
            		move(cur, 2);
            		move(cur, 3);
            	}
            	else if(cur[2]==7) {
            		move(cur, 0);
            		move(cur, 3);
            	}
            	
            	if(flag) break;
            }
            
            int ans=0;
            for(int i=0; i<n; i++) {
            	for(int j=0; j<m; j++) {
               //     System.out.print(dist[i][j]+" ");
            		if(dist[i][j] != 0 && dist[i][j]<=l)
            			ans++;
            	}
             //   System.out.println();
            }
            System.out.println("#"+test_case+" "+ans);
		}
	}
}
