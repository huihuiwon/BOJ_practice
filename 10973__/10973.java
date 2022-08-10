import java.util.*;
import java.io.*;


public class Main {


	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i]=sc.nextInt();
		
		boolean flag=true;
		for(int i=n-2; i>=0; i--) {
			int index=-1;
			for(int j=i+1; j<n; j++) {
				if(arr[i] > arr[j]) {
					index=j;
				}
			}
			if(index != -1) {
				int tmp=arr[i];
				arr[i]=arr[index];
				arr[index]=tmp;
				
				int[] new_arr = Arrays.copyOfRange(arr, i+1, n);
				for(int k=0; k<=i; k++)
					System.out.print(arr[k]+" ");
				Arrays.parallelSort(new_arr);
				for(int k=n-1; k>i; k--) {
					System.out.print(arr[k]+" ");
				}
				
				flag=false;
				break;
			}
		}

		if(flag) System.out.println(-1);
	}
	
}
