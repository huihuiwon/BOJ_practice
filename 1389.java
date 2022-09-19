import java.util.*;
import java.io.*;


public class Main {	

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int m=sc.nextInt();
		int map[][]=new int[n+1][n+1];
		for(int i=1; i<=n; i++)
			Arrays.fill(map[i], 250000);
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt(); int b = sc.nextInt();
			map[a][b]=1;
			map[b][a]=1;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=n; k++) {
					if(map[j][i] + map[i][k] < map[j][k]) {
						map[j][k] = map[j][i]+map[i][k];
					}
				}
			}
		}
		
		
		int min = Integer.MAX_VALUE;
		int result = -1;
		for(int i=1; i<=n; i++) {
			int sum = 0;
			for(int j=1; j<=n ;j ++) {
				if(i == j) continue;
				sum += map[i][j];
			}
			if(min > sum) {
				min = sum;
				result= i;
			}
		}
		
		System.out.println(result);
	}
}

***
한 정점으로부터 나머지 모든 정점으로의 거리가 아니라
모든 정점으로부터 나머지 모든 정점까지 거리를 구해야 하므로
플로이드-워샬 알고리즘 필요
