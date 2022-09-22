import java.util.*;
import java.io.*;


public class Main {	

	static ArrayList<ArrayList<Integer>> graph;
	static int n;
	static boolean chk[];
	static int result[];
	static int cnt=1;
	static HashMap<Integer, Integer> hm = new HashMap<>();
	public static void DFS(int L, int v) {
		result[v] = cnt++;
		chk[v] = true;
		for(int i : graph.get(v)) {
			if(!chk[i]) {
				DFS(L+1, i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); int m = sc.nextInt(); int r = sc.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++)
			graph.add(new ArrayList<Integer>());
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt(); int b = sc.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for(int i=1; i<=n; i++)
			Collections.sort(graph.get(i), Collections.reverseOrder());

		
		chk = new boolean[n+1];
		result = new int[n+1];
		DFS(1, r);
		
		
		for(int i=1; i<=n; i++) {
			System.out.println(result[i]);
		}
	}
	
}
