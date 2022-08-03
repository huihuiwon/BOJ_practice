import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int arr[]=new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		int s = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int max = -1, tmp = -1;
			for(int j=i; j < n && j <= i+s; j++) {
				if(max < arr[j]) {
					max = arr[j];
					tmp = j;
				}
			}

			for(int j=i+1; j<=tmp; j++) {
				int t = arr[j];
				arr[j]=arr[i];
				arr[i]=t;
	
				s--;
			}

			if(s==0) break;
		}


		for(int a : arr) {
			System.out.print(a+" ");
		}
	}
	
}