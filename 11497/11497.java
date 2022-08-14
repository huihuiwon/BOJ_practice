import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n=sc.nextInt();
			int arr[]=new int[n];
			for(int i=0; i<n; i++)
				arr[i]=sc.nextInt();
			Arrays.sort(arr);
			
			int s=0;
			ArrayList<Integer> tmp = new ArrayList<>();
			while(true) {
				tmp.add(arr[s]);
				if(s==n-1)
					break;
				
				if(s==n-2) {
					s=n-1;
					tmp.add(arr[s]);
					break;
				}
				s+=2;
			}
			
			if(n%2==0) s-=2;
			else s-=1;
			while(s!=0) {
				tmp.add(arr[s]);
				if(s==1) {
					s=0;
					tmp.add(arr[s]);
					break;
				}
				s-=2;
			}
			
			int diff=0;
			for(int i=0; i<tmp.size()-1; i++) {
				diff=Math.max(diff, Math.abs(tmp.get(i+1)-tmp.get(i)));
			}
			
			System.out.println(diff);
		}
	}
	
}
