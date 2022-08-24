import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			String arr[]=new String[n];
			for(int i=0; i<n; i++)
				arr[i]=br.readLine();
			Arrays.sort(arr);


			boolean chk=false;
			for(int i=0; i<n-1; i++) {
				boolean flag=false;
				if(arr[i].length() >= arr[i+1].length()) {
					flag=true;
					continue;
				}
				for(int j=0; j<arr[i].length(); j++) {
					if(arr[i].charAt(j) != arr[i+1].charAt(j)) {
						flag=true;
					}
				}
				if(!flag) {
					chk=true;
					break;
				}
			}
			if(chk) System.out.println("NO");
			else System.out.println("YES");
		}
	}
}
