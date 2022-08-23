import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); int k=sc.nextInt();
		int cost[]=new int[n];
		for(int i=0; i<n; i++)
			cost[i]=sc.nextInt();
		
		int diff[]=new int[n-1];
		for(int i=1; i<n; i++) {
			diff[i-1]=cost[i]-cost[i-1];
		}
		
		Arrays.parallelSort(diff);
		int result=0;
		for(int i=0; i<n-k; i++)    // 처음에 k-1 까지라고 했는데 n-k 가 맞다! n-1개의 diff 중에 k-1개 빼고 뽑아야 함
			result += diff[i];
		
		System.out.println(result);
	}
	
}
