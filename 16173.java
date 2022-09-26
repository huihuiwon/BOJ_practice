import java.util.*;
import java.io.*;


public class Main {	

	static ArrayList<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int map[][]=new int[n+1][n+1];
		
		for(int i=1; i<=n; i++)
			for(int j=1; j<=n; j++)
				map[i][j]=sc.nextInt();
		
		Queue<int[]> q = new LinkedList<>();
		boolean chk[][]=new boolean[n+1][n+1];
		q.add(new int[] {1,1});
		chk[1][1]=true;

		int dx[]= {0,1};
		int dy[]= {1,0};
		while(!q.isEmpty()) {
			int cur[]=q.poll();
			chk[cur[0]][cur[1]]=true;
			for(int dir=0; dir<2; dir++) {
				int nx = cur[0]+dx[dir]*map[cur[0]][cur[1]];  // dx[dir]*map[cur[0]][cur[1]] 로 현재 칸에 쓰인 수만큼 이동을 표현
				int ny = cur[1]+dy[dir]*map[cur[0]][cur[1]];  // 위와 동일
				
				if(nx<=0 || ny<=0 || nx> n || ny>n) continue;
				if(chk[nx][ny]) continue;
				if(map[nx][ny]==-1) {
					System.out.println("HaruHaru");
					return;
				}
				
				q.add(new int[] {nx, ny});
				chk[nx][ny]=true;
			}
		}


		System.out.println("Hing");  // 위에서 리턴되지 않았으면 도달할 수 없다는 뜻
	}
	
}
