import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int m = sc.nextInt(); 
		int x = sc.nextInt(); int y = sc.nextInt(); int k = sc.nextInt();
		
		int map[][]=new int[n][m];
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				map[i][j] = sc.nextInt();


		int dice[] = new int[6];
		
		int dx[]= {0,0,-1,1};
		int dy[]= {1,-1,0,0};
		
		for(int i=0; i<k; i++) {
			int dir = sc.nextInt();
			
			int nx = x+dx[dir-1]; int ny = y+dy[dir-1];
			if(nx < 0 || ny< 0 || nx>= n || ny>=m ) continue;
			
			int a=dice[0]; int b=dice[1]; int c=dice[2]; int d=dice[3]; int e=dice[4]; int f=dice[5];
			if(dir==1) {
				dice[0]=a; dice[1]=e; dice[2]=c; dice[3]=f; dice[4]=d; dice[5]=b;
			}
			else if(dir==2) {
				dice[0]=a; dice[1]=f; dice[2]=c; dice[3]=e; dice[4]=b; dice[5]=d;
			}
			else if(dir==3) {
				dice[0]=b; dice[1]=c; dice[2]=d; dice[3]=a; dice[4]=e; dice[5]=f;
			}
			else {
				dice[0]=d; dice[1]=a; dice[2]=b; dice[3]=c; dice[4]=e; dice[5]=f;
			}
				
			
			if(map[nx][ny] != 0) {
				dice[3] = map[nx][ny];
				map[nx][ny]=0;
			}
			else {
				map[nx][ny] = dice[3];
			}
			
			x = nx; y= ny;
//			
//			for(int d : dice)
//				System.out.print(d+" ");
//			System.out.println();
			System.out.println(dice[1]);
		}
	}
}
