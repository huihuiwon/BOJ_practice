import java.util.*;
import java.io.*;

class Node {
	int num; int dir;
	Node(int num, int dir){
		this.num= num;
		this.dir=dir;
	}
	
	
}

class qNode implements Comparable<qNode>{
	int x; int y; int num; int dir;
	qNode(int x, int y, int num, int dir){
		this.x=x;
		this.y=y;
		this.num= num;
		this.dir=dir;
	}
	
	public int compareTo(qNode o) {
		return o.num-this.num;
	}
}
class Main {

	static int n, m, k;
	static Node map[][];

	static int dx[]= {0, -1, 1, 0, 0};
	static int dy[]= {0, 0, 0, -1, 1};
	
	static int move[] = {0, 2, 1, 4, 3};
	static PriorityQueue<qNode> q;
	
	public static void change() {

		map = new Node[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				map[i][j] = new Node(0, 0);
		
		

		while(!q.isEmpty()) {
			qNode cur = q.poll();

			int nx = cur.x+dx[cur.dir];
			int ny = cur.y+dy[cur.dir];
			
			if(nx == 0 || ny == 0 || nx == n-1 || ny == n-1) {
				if(map[nx][ny].num == 0)
					map[nx][ny] = new Node(cur.num/2, move[cur.dir]);
				else {
					if(map[nx][ny].num > cur.num/2)
						map[nx][ny] = new Node(map[nx][ny].num + cur.num/2, map[nx][ny].dir);
					else
						map[nx][ny] = new Node(map[nx][ny].num + cur.num/2, move[cur.dir]);
				}
			}
			else {
				
				if(map[nx][ny].num == 0)
					map[nx][ny] = new Node(cur.num, cur.dir);
				else {
					if(map[nx][ny].num > cur.num)
						map[nx][ny] = new Node(map[nx][ny].num + cur.num, map[nx][ny].dir);
					else
						map[nx][ny] = new Node(map[nx][ny].num + cur.num, cur.dir);
				}
			}
		}
		
		q = new PriorityQueue<>();

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j].num != 0) {
					q.add(new qNode (i, j, map[i][j].num, map[i][j].dir));
				}
			}
		}
		
	}
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
			map = new Node[n][n];
			
			
			q = new PriorityQueue<>();
			
			for(int i=0; i<k; i++) {
				int a = sc.nextInt(); int b = sc.nextInt(); int c = sc.nextInt(); int d = sc.nextInt();
				q.add(new qNode (a, b, c, d));
			}
			
			for(int i=0; i<m; i++)
				change();


			int ans = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j].num == 0) continue;
					else ans += map[i][j].num;
				}
			}
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
}
