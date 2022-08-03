import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int k = sc.nextInt();
		int arr[]=new int[n];
		for(int i=0; i<n; i++)
			arr[i]=sc.nextInt();
		
		if(n <= k) {
			System.out.println(0);
			return;
		}
		
		Arrays.sort(arr);
		
		Integer dif[]=new Integer[n-1];
		for(int i=1; i<n; i++)
			dif[i-1]=arr[i]-arr[i-1];
		Arrays.sort(dif, Collections.reverseOrder());
		
		int result=0;
		for(int i=k-1; i<n-1; i++)
			result += dif[i];
		
		System.out.println(result);
	}
	
}