import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); int k=sc.nextInt();
		int num[]=new int[n];
		for(int i=0; i<n; i++) {
			num[i]=sc.nextInt();
		}
		
		int max=Integer.MIN_VALUE; int sum=0;
		for(int i=0; i<k-1; i++)
			sum+=num[i];
		
		for(int i=k-1; i<n; i++) {
			sum += num[i];
			max = Math.max(sum, max);
			sum -= num[i-k+1];
		}
		
		System.out.println(max);
	}
	
}
