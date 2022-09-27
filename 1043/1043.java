import java.util.*;
import java.io.*;


public class Main {

	static HashSet<Integer> hs = new HashSet<>();
	static boolean chk[];
	static ArrayList<ArrayList<Integer>> list;
	public static void DFS(int start) {
		chk[start] = true;
		hs.add(start);
		for(int v : list.get(start)) {
			if(chk[v]) continue;
			chk[v]=true;
			hs.add(v);
			DFS(v);
		}
	}
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt(); int m = sc.nextInt();
    	chk = new boolean[n+1];
    	list = new ArrayList<ArrayList<Integer>>();
    	for(int i=0; i<=n; i++)
    		list.add(new ArrayList<Integer>());
    	
    	int num = sc.nextInt();
    	for(int i=0; i<num; i++) {
    		hs.add(sc.nextInt());
    	}
    	
    	int map[][]=new int[m][n+1];
    	for(int i=0; i<m; i++) {
    		map[i][0] = sc.nextInt(); boolean flag = true;
    		for(int j=1; j<=map[i][0]; j++) {
    			map[i][j]=sc.nextInt();
    			if(hs.contains(map[i][j])) {
    				flag= false;
    			}
    		}
    		
    		if(!flag) {
    			for(int j=1; j<=map[i][0]; j++) {
    				DFS(map[i][j]);
    			}
    		}
    	}
    
    	int cnt = 0;
    	for(int k=0; k<m; k++) {
        for(int i=0; i<m; i++) {
          boolean flag = true;
          for(int j=1; j<=map[i][0]; j++) {
            if(hs.contains(map[i][j])) {
              flag= false;
            }
          }

          if(k==m-1 && flag) cnt++;
          if(!flag) {
            for(int j=1; j<=map[i][0]; j++) {
              DFS(map[i][j]);
            }
          }
        }
    	}
    	
    	System.out.println(cnt);
    }
}
