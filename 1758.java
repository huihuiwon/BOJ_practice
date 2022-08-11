import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer arr[] = new Integer[n];

		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr, Comparator.reverseOrder());

		long result = 0;  // result값이 int의 범위를 넘을 수도 있다. N은 100,000 이하이고 팁도 100,000 이하이기 때문
		for(int i=0; i<n; i++) {
			if(arr[i] - i < 0) continue;
			result += arr[i] - i;
		}	
		
		System.out.println(result);
	}
	
}
