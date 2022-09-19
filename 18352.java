import java.util.*;
import java.io.*;


class Node implements Comparable<Node>{
	int e;
	int dist;
	Node(int e, int dist){
		this.e=e;
		this.dist=dist;
	}
	public int compareTo(Node o) {
		return this.dist-o.dist;
	}
}
public class Main {	
	static ArrayList<Node>[] graph;
	
	public static int[] dij(int n, int x) {
		int dist[]=new int[n+1];
		Arrays.fill(dist,  Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(x, 0));
		dist[x]=0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(dist[cur.e] < cur.dist) continue;
			for(Node nxt : graph[cur.e]) {
				if(dist[nxt.e] > dist[cur.e]+nxt.dist) {
					dist[nxt.e] = dist[cur.e]+nxt.dist;
					pq.add(new Node(nxt.e, dist[nxt.e]));
				}
			}
		}
		return dist;
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int m=sc.nextInt();
		int k = sc.nextInt(); int x = sc.nextInt();

		graph = new ArrayList[n+1];
		for(int i=0; i<=n; i++)
			graph[i]=new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(new Node(b, 1));
		}
		
		int dist[]=dij(n, x);
		boolean flag=true;
		for(int i=1; i<=n; i++) {
			if(i==x) continue;
			if(dist[i] == k) {
				flag=false;
				System.out.println(i);
			}
		}
		if(flag)
			System.out.println(-1);
	}
	
}
