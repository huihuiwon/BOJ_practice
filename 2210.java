import java.util.*;
import java.io.*;


public class Main {

	static int[][] map=new int[5][5];
	static int dx[]= {0,1,0,-1};
	static int dy[]= {1,0,-1,0};
	static HashSet<String> hs = new HashSet<>();  // 중복을 제외하기 위함
	
	public static void DFS(int L, int i, int j, String str) {
		if(L==6) {
			hs.add(str);
			return;
		}
		
		for(int dir=0; dir<4; dir++) {
			int nx = dx[dir]+i;
			int ny = dy[dir]+j;
			if(nx< 0 || ny< 0|| nx>=5 || ny>=5) continue;
			
			DFS(L+1, nx, ny, str+map[i][j]+"");
		}
	}
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	for(int i=0; i<5; i++) {
    		for(int j=0; j<5; j++) {
    			map[i][j] = sc.nextInt();
    		}
    	}
    	
    	for(int i=0; i<5; i++) {
    		for(int j=0; j<5; j++) {
    			DFS(0, i, j, "");
    		}
    	}
    	
    	System.out.println(hs.size());
    }
}
