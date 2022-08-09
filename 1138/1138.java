import java.util.*;
import java.io.*;


public class Main {


	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[]=new int[n];
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		result.add(n);
		for(int i=n-2; i>=0; i--) {
			if(arr[i] == 0) result.add(0, i+1);
			else if(result.size() <= arr[i]) result.add(i+1);
			else {
				result.add(arr[i], i+1);
			}
		}
		
		for(int r : result)
			System.out.print(r+" ");
	}
	
}
