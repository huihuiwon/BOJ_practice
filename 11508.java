import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		Integer arr[]=new Integer[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr, Collections.reverseOrder()); int result=0;
		for(int i=0; i<n; i++) {
			if(i%3==2) continue;
			result += arr[i];
		}
		System.out.println(result);
	}
	
}
