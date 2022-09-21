import java.util.*;
import java.io.*;


public class Main {	

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
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
			map[b][a] = c;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=n; k++) {
					if(map[j][i] == Integer.MAX_VALUE || map[i][k] == Integer.MAX_VALUE) continue;
					map[j][k]=Math.min(map[j][k], map[j][i]+map[i][k]);
				}
			}
		}
		
		int a = sc.nextInt(); int b = sc.nextInt();
		
		int result = 0; boolean flag=true;
		if(map[1][a] != Integer.MAX_VALUE) result += map[1][a];
		else flag= false;
		if(map[a][b] != Integer.MAX_VALUE) result += map[a][b];
		else flag= false;
		if(map[b][n] != Integer.MAX_VALUE) result += map[b][n];
		else flag= false;
		
		int result2= 0; boolean flag2=true;
		if(map[1][a] != Integer.MAX_VALUE) result2 += map[1][b];
		else flag2= false;
		if(map[b][a] != Integer.MAX_VALUE) result2 += map[b][a];
		else flag2= false;
		if(map[a][n] != Integer.MAX_VALUE) result2 += map[a][n];
		else flag2= false;

		if(flag && flag2) System.out.println(Math.min(result2, result));
		else if(!flag2 && flag) System.out.println(result);
		else if(!flag && flag2) System.out.println(result2);
		else System.out.println(-1);

	}
	
}
