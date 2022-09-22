import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static boolean list[][];
	static boolean visited[];
	static Queue<Integer> q;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int v=Integer.parseInt(st.nextToken());

		list = new boolean[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int tmp=Integer.parseInt(st.nextToken());
			int tmp2=Integer.parseInt(st.nextToken());
			
			list[tmp][tmp2]=true;
			list[tmp2][tmp]=true;
		}
		
		dfs(list, v);
		System.out.println(" ");
		visited = new boolean[n+1];
		q=new LinkedList<Integer>();
		bfs(list, v);
	}
	
	public static void dfs(boolean[][] list, int v) {
		System.out.print(v);
		visited[v]=true;
		for(int i=1; i<list[v].length; i++) {
			if(list[v][i] && !visited[i]) {
				System.out.print(" ");
				dfs(list, i);
			}
		}
	}
	
	public static void bfs(boolean [][] list, int v) {
		List a = new ArrayList<Integer>();
		q.offer(v);
		visited[v]=true;
		while(!q.isEmpty()) {
			int tmp=q.poll();
			a.add(tmp);
			for(int i=1; i<list.length; i++) {
				if(list[tmp][i] && !visited[i]) {
					q.offer(i);
					visited[i]=true;
				}
			}
		}
		
		for(int i=0; i<a.size(); i++) {
			System.out.print(a.get(i));
			if(i != a.size() -1) {
				System.out.print(" ");
			}
		}
	}
}
