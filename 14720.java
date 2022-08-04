import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		int arr[]=new int[t];
		
		int milk[]=new int[] {0, 1, 2};
		int index=0; int result=0;
		
		for(int i=0; i<t; i++) {
			arr[i]=sc.nextInt();
			if(milk[index]==arr[i]) {
				index++;
				result++;
			}
			if(index==3) index=0;
		}
		
		System.out.println(result);
	}
	
}
