import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt(); int l=sc.nextInt();
		int arr[]=new int[t];
		
		for(int i=0; i<t; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		for(int i=0; i<t; i++) {
			if(arr[i] <= l)
				l++;
		}
		System.out.println(l);
	}
	
}
