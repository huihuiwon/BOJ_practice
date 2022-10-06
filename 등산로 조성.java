import java.util.Scanner;
import java.io.FileInputStream;

class Node {
	int a, b, h;
    Node(int a, int b, int h){
    	this.a=a;
        this.b=b;
        this.h=h;
    }
}
class Solution {
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    static int max = 0;
    
    static int[][] map;
    static boolean[][] chk;
    static int n=0, k=0;
    
    public static void DFS(Node cur, int count, boolean flag) {
        chk[cur.a][cur.b]=true;
        max = Math.max(max, count);
        
        for(int dir=0; dir<4; dir++) {
        	int nx = dx[dir]+cur.a;
            int ny = dy[dir]+cur.b;
            
            if(nx< 0 || ny<0 || nx>=n || ny>=n) continue;   // 처음에 return 해줘서 틀림! continue
            if(chk[nx][ny]) continue;
            
            chk[nx][ny]=true;
            if(map[nx][ny] < cur.h) {
                DFS(new Node(nx, ny, map[nx][ny]), count+1, flag);
            }
            else {
            	if(flag==true && (map[nx][ny]-k < cur.h)) {
                	DFS(new Node(nx, ny, cur.h-1), count+1, false);
                }
            }
            chk[nx][ny]=false;
        }
        chk[cur.a][cur.b]=false;
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt(); k = sc.nextInt();
            map=new int[n][n];
            
            int highest= 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++){
                    map[i][j] = sc.nextInt();
                    highest = Math.max(map[i][j], highest);
                }
            }
            
            chk = new boolean[n][n];
            max = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++){
                    if(map[i][j]==highest){
                        DFS(new Node(i, j, map[i][j]), 1, true);
                    }
                }
            }
            
            System.out.println("#"+test_case+" "+max);
        }
    }
}
