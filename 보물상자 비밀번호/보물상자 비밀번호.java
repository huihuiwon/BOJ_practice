import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		int arr[]= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt(); int k = sc.nextInt();
			sc.nextLine();
			StringBuilder sb = new StringBuilder(sc.nextLine());

			TreeSet<Integer> hs = new TreeSet<>();
			int div = n/4;
			for(int a=0; a<div; a++) {
				for(int i=0; i<4; i++) {
					int sum = 0; int cur = div-1;
					for(int j=i*div; j<i*div+div; j++) {
						char c = sb.charAt(j); int index=0;
						if(!Character.isDigit(c)) index = c-'A'+10;
						else index = c-'0';
						sum += Math.pow(16, cur--)*(arr[index]);
					}
					hs.add(sum);
				}
				sb.insert(0, sb.charAt(n-1));
				sb.deleteCharAt(n);
			}


			
			Integer[] arr2 = new Integer[hs.size()];
			hs.toArray(arr2);
			
			System.out.println("#"+test_case+" "+arr2[hs.size()-k]);
		}
	}
}
