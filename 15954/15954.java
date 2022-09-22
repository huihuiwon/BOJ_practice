import java.util.*;
import java.io.*;


public class Main {	

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int k = sc.nextInt();
		
		int doll[]=new int[n];
		for(int i=0; i<n; i++) {
			doll[i]=sc.nextInt();
		}
		
		double result = Double.MAX_VALUE;
		for(int i=0; i<=n-k; i++) {
			for(int t=k; t<=n-i; t++) {
				int sum = 0;
				for(int j=i; j<i+t; j++) {
					sum += doll[j];
				}
				double m = sum/(t*1.0);
	
				double tmp = 0;
				for(int j=i; j<i+t; j++) {
					tmp += Math.pow(doll[j]-m, 2);
				}
	
				tmp /= t;
				tmp = Math.sqrt(tmp);
	
				result = Math.min(result, tmp);
			}
		}
		
		System.out.println(String.format("%.11f", result));
	}
	
}
