import java.util.*;
import java.io.*;


public class Main {	

	static ArrayList<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int m = sc.nextInt();
		
		
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++)
			list.add(new ArrayList<Integer>());
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt(); int b = sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		boolean chk[]=new boolean[n+1];
		chk[1] = true;
		int count= 0;
		for(int v : list.get(1)) {
			if(!chk[v]) {   // 깊이가 1인 경우 (상근이의 친구)
				chk[v]=true;
				count++;
			}
			for(int j : list.get(v)) {
				if(!chk[j]) {  // 깊이가 2인 경우 (상근이의 친구의 친구)
					chk[j]=true;
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
	
}
