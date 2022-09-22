import java.util.*;
import java.io.*;


public class Main {	

	static ArrayList<ArrayList<Integer>> list;
	static boolean chk[];
	static boolean flag = false;
	public static void DFS(int start, int L) {
		if(L == 5) {
			flag = true;
			return;
		}
		
		chk[start] = true;
		for(int v : list.get(start)) {
			if(!chk[v]) {
				DFS(v, L+1);
			}
		}
		chk[start] = false;
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int m = sc.nextInt();
		
		
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<n; i++)
			list.add(new ArrayList<Integer>());
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt(); int b = sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
	
		for(int i=0; i<n; i++) {
			chk = new boolean[n];
			DFS(i, 1);
			if(flag) {
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(0);
	}
	
}
