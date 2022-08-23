import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int cost[]=new int[n];
		for(int i=0; i<n; i++)
			cost[i]=sc.nextInt();
		
		int result=0;
		Arrays.parallelSort(cost);
		for(int i=0; i<n-1; i++)
			result += cost[i];
		System.out.println(result);
	}
	
}
