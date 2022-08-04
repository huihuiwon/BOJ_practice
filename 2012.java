// 그리디

import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int s[]=new int[n];
		for(int i=0; i<n; i++)
			s[i]=sc.nextInt();

		Arrays.parallelSort(s);
		long result = 0;
		for(int i=0; i<n; i++) {
			if(s[i] == i+1) continue;
			result += Math.abs(s[i] - (i + 1));
		}
		
		System.out.println(result);
	}
	
}


/* result의 자료형은 int가 아닌 long형이어야 한다
마지막에 s[i] == i+1 확인하고 Math.abs를 구하는 for문에서 i=n-1 ~ 0 까지 했더니 오답이 나왔찌만
0~n-1 까지 하니 정답 */
