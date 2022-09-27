import java.util.*;
import java.io.*;


public class Main {

	static int cnt=0;
	static int cnt2=0;
	static int n;
	static boolean chk[];
	static ArrayList<ArrayList<Integer>> list;
	static ArrayList<ArrayList<Integer>> list2;
	public static void DFS(int start) {
		chk[start] = true;
		for(int v : list.get(start)) {
			if(chk[v]) continue;
			cnt++;
			chk[v]=true;
			DFS(v);
		}
	}
	
	public static void reverse_DFS(int start) {
		chk[start] = true;
		for(int v : list2.get(start)) {
			if(chk[v]) continue;
			cnt2++;
			chk[v]=true;
			reverse_DFS(v);
		}
	}
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt(); int m = sc.nextInt();
    	list = new ArrayList<ArrayList<Integer>>();
    	list2 = new ArrayList<ArrayList<Integer>>();
    	for(int i=0; i<=n; i++) {
    		list.add(new ArrayList<Integer>());
    		list2.add(new ArrayList<Integer>());
    	}
    	chk = new boolean[n+1];
    	
    	for(int i=0; i<m; i++) {
    		int a = sc.nextInt(); int b = sc.nextInt();
    		list.get(a).add(b);
    		list2.get(b).add(a);
    	}
    	
    	int result[]=new int[n+1];
    	for(int i=1; i<=n; i++) {
    		chk = new boolean[n+1];
    		DFS(i);
    		result[i] = cnt;
    		cnt=0;
    	}
    	
    	int ans = 0;
    	for(int i=1; i<=n; i++) {
    		chk = new boolean[n+1];
    		reverse_DFS(i);
    		result[i] += cnt2;
    		if(result[i] == n-1) ans++;
    		cnt2=0;
    	}
      
    	System.out.println(ans);
    }
}
