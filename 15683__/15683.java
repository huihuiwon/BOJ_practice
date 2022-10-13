import java.util.*;
import java.io.*;

class Main {
	
	static int cctv_cnt;
	static ArrayList<int[]> cctv;
	static int n, m;
	static int map[][];
	

	static int dx[]= {0, -1, 0, 1}; // 0 오 1 위 2 왼 3 아
	static int dy[]= {1, 0, -1, 0};
	static int cam[][] = {
			{1, 0, 0, 0, 4},
			{1, 0, 1, 0, 2},
			{1, 1, 0, 0, 4},
			{1, 1, 1, 0, 4},
			{1, 1, 1, 1, 1}
	}; // 카메라 타입별로 초기값 + 만들 수 있는 경우

	static void watch(int r, int c, int dir) {
		int curx = r; int cury = c;
		for(;;) {
			int nx = curx+dx[dir]; int ny = cury+dy[dir];
			if(nx< 0 || ny< 0|| nx>=n || ny>=m) return;
			if(map[nx][ny] == 6) return;
			
			map[nx][ny] = 7; //감시했다
			curx = nx;
			cury = ny;
		}
	}
	static void copymap(int[][] a, int[][] b) {
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				a[i][j] = b[i][j];
	}
	public static int order(int L) {
		if(L == cctv_cnt) {
			int sum = 0;
			for(int i=0; i<n; i++)
				for(int j=0; j<m; j++)
					if(map[i][j] == 0) ++sum;
			
			return sum;
		}
		
		int[][] tmp = new int[n][m];
		int min = 987654321;
		
		int type = cctv.get(L)[2] - 1;
		for(int i=0; i<cam[type][4]; i++) {
			copymap(tmp, map);
			for(int j=0; j<4; j++) {
				if(cam[type][j] == 1)
					watch(cctv.get(L)[0], cctv.get(L)[1], (i+j)%4);
			}
			
			min = Math.min(min, order(L+1));
			copymap(map, tmp);
		}

		return min;
	}
	public static void main(String args[]) throws Exception	{
		
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		map = new int[n][m];
		
		cctv = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j]= sc.nextInt();
				if(map[i][j] >= 1 && map[i][j] <= 5)
					cctv.add(new int[] {i, j, map[i][j]});
			}
		}
		
		cctv_cnt = cctv.size();
		
		
		System.out.println(order(0));
		
	}
}
