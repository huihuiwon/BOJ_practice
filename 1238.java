import java.util.*;
import java.io.*;


public class Main {	

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		
		int map[][]=new int[n+1][n+1];

		for(int i=0; i<=n; i++) {
			for(int j=0; j<=n; j++) {
				map[i][j] = Integer.MAX_VALUE;
				if(i== j ) map[i][j]=0;
			}
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt(); int b = sc.nextInt(); int c = sc.nextInt();
			map[a][b] = c;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=n; k++) {
					if(map[j][i] == Integer.MAX_VALUE || map[i][k] == Integer.MAX_VALUE) continue;
					map[j][k]=Math.min(map[j][k], map[j][i]+map[i][k]);
				}
			}
		}
		
		
		int max = 0;
		for(int i=1; i<=n; i++) {
			max = Math.max(map[i][x]+map[x][i], max);
		}
		

		System.out.println(max);
	}
	
}
