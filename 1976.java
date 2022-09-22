import java.util.*;
import java.io.*;


public class Main {	

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 도시의 개수
    int m = sc.nextInt();  // 여행 계획에 속한 도시의 수
		
		int map[][]=new int[n][n];
		for(int i=0; i<n; i++)
			Arrays.fill(map[i], 100000);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int x = sc.nextInt();
				if(x==1)
					map[i][j]=x;
				if(i==j) map[i][j]= 1;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					map[j][k] = Math.min(map[j][k], map[j][i]+map[i][k]);
				}
			}
		}
		
		int plan[]=new int[m];
		for(int i=0; i<m; i++) {
			plan[i]=sc.nextInt()-1;
		}
		
		boolean flag = true;
		for(int i=1; i<m; i++) {
			if(map[plan[i-1]][plan[i]] == 100000) {
				flag = false;
				break;
			}
		}
		
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
	
}


***
3
2
0 0 0
0 0 0
0 0 0
1 1

이 입력으로 들어오면 YES가 나와야 한다
그래프상으로는 표현되지 않지만 현실적으로 1->1 로 가는 것은 가능하기 때문,,
