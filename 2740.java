import java.util.*;
import java.io.*;


public class Main {


	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); int m=sc.nextInt();
		int map[][]=new int[n][m];
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++) {
				map[i][j]=sc.nextInt();
			}
		
		m=sc.nextInt(); int k=sc.nextInt();
		int map2[][]=new int[m][k];
		for(int i=0; i<m; i++)
			for(int j=0; j<k; j++) {
				map2[i][j]=sc.nextInt();
			}
		
		int result[][]=new int[n][k];
		for(int i=0; i<n; i++) {
			for(int j=0; j<k; j++) {
				for(int t=0; t<m; t++) {
					result[i][j] += map[i][t]*map2[t][j];
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<k; j++) {
				System.out.print(result[i][j] +" ");
			}
			System.out.println();
		}
	}
	
}
