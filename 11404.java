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
			map[a][b]=Math.min(map[a][b], c);   // a->b 경로가 하나가 아닐 수도 있음
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=n; k++) {
					if(map[j][i] == Integer.MAX_VALUE || map[i][k] == Integer.MAX_VALUE) continue;
          // 무한대 + N 을 하게 되면 Int형 범위를 넘어서서 오히려 마이너스가 될 수도 있음
          // 사전 방지 위해 둘 중 하나가 MAX_VALUE면 continue;
					map[j][k]=Math.min(map[j][k], map[j][i]+map[i][k]);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j] != Integer.MAX_VALUE) System.out.print(map[i][j]+" ");
				else System.out.print(0+" ");
			}
			System.out.println();
		}
	}
	
}
