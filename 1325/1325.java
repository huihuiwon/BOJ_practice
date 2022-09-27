import java.util.*;
import java.io.*;


public class Main {	
	
	static ArrayList<ArrayList<Integer>> list;
	static boolean chk[];
	static int cnt=0;
	static int result[];
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		chk[start]=true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int v : list.get(x)) {
				if(!chk[v]) {
					chk[v]=true;
					result[v]++;
					q.offer(v);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String tmp[]=br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]); int m = Integer.parseInt(tmp[1]);
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++)
			list.add(new ArrayList<Integer>());
		
		for(int i=0; i<m; i++) {
			tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]); int b = Integer.parseInt(tmp[1]);
			list.get(a).add(b);
		}

		result = new int[n+1];

		for(int i=1; i<=n; i++) {
			chk = new boolean[n+1];
			BFS(i);
			cnt=0;
		}
		
		int ans = 0;
		for(int i=1; i<=n; i++) {
			ans = Math.max(ans, result[i]);
		}

		for(int i=1; i<=n ;i++) {
			if(ans == result[i])
				bw.write(i+" ");
//				System.out.print(i+" ");
		}
		bw.flush();
		bw.close();
	}
}
