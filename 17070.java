import java.util.*;
import java.io.*;


public class Main {

	static int[][] map;
	static int n;
	static int ans=0;
	public static void DFS(int x1, int y1, int x2, int y2) {
		if((x1==n-1 && y1==n-1) || (x2==n-1 && y2==n-1)) {
			ans++;
			return;
		}
		
		if(x1==x2) {
			if(y2 < n-1 && map[x2][y2+1]!=1)
				DFS(x2, y2, x2, y2+1);
			
			if(x2 < n-1 && y2 < n-1 && map[x2+1][y2+1]!=1 && map[x2][y2+1]!=1 && map[x2+1][y2]!=1)
				DFS(x2, y2, x2+1, y2+1);
		}
		
		else if(y1==y2) {
			if(x2 < n-1 && map[x2+1][y2]!=1) 
				DFS(x2, y2, x2+1, y2);
			
			if(x2 < n-1 && y2 < n-1 && map[x2+1][y2+1]!=1 && map[x2][y2+1]!=1 && map[x2+1][y2]!=1)
				DFS(x2, y2, x2+1, y2+1);
		}
		
		else if(x1+1 == x2) {
			if(y2 < n-1 && map[x2][y2+1]!=1)
				DFS(x2, y2, x2, y2+1);
			
			if(x2 < n-1 && map[x2+1][y2]!=1)
				DFS(x2, y2, x2+1, y2);
			
			if(x2 < n-1 && y2 < n-1 && map[x2+1][y2+1]!=1 && map[x2][y2+1]!=1 && map[x2+1][y2]!=1)
				DFS(x2, y2, x2+1, y2+1);
			
		}
	}
    public static void main(String[] args) throws IOException {
    	//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Scanner sc = new Scanner(System.in);
    	n= sc.nextInt();  // 전역변수로 선언하고 그걸 쓰고 싶으면 지역변수 따로 선언하면 안된다
    	map=new int[n][n];
    	for(int i=0; i<n; i++)
    		for(int j=0; j<n; j++) 
    			map[i][j]=sc.nextInt();
    		
    	DFS(0, 0, 0, 1);
    	
    	System.out.println(ans);
    }
}
