import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n= Integer.parseInt(br.readLine());
			char arr1[]=br.readLine().toCharArray();
			char arr2[]=br.readLine().toCharArray();
			
			int w_cnt=0; int b_cnt=0;
			for(int i=0; i<n; i++) {
				if(arr1[i] == arr2[i]) continue;
				if(arr1[i]=='W') w_cnt++;
				else b_cnt++;
			}
			
			int diff=Math.abs(w_cnt-b_cnt);
			diff += (w_cnt+b_cnt-diff)/2;
			
			System.out.println(diff);
		}
		
	}
}


***
arr는 현재 상태 arr2는 목표 상태
만약 arr[i] == arr2[i] 라면 현재 상태와 목표 상태가 같다는 뜻이므로 continue
아닌 경우에는 cnt를 구해줘야한다

만약 현재 상태가 W이고 목표 상태와 같지 않다면 w_cnt++
아니면 b_cnt++
  
최종적으로 만약 위치가 맞지 않는 W와 B의 개수가 각각 4개라면,
서로의 위치를 4번 바꾸는 것이 최소 횟수

만약 W의 개수는 8개이고, B의 개수는 5개라면
W 3개는 뒤집어서 색깔을 변경하고
5개는 서로 바꾸는 것이 최소 횟수

이를 구하는 방법은 우선 w_cnt와 b_cnt의 차이를 구해놓고,
diff+=(w_cnt+b_cnt-diff)/2 를 하면 된다
