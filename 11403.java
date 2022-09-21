import java.util.*;
import java.io.*;


public class Main {	

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		
		int map[][]=new int[n][n];
		for(int i=0; i<n; i++)
			Arrays.fill(map[i], 10001);
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int x = sc.nextInt();
				if(x==1)
					map[i][j]=1;
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(map[j][i] + map[i][k] < map[j][k])
						map[j][k] = map[j][i] + map[i][k];
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==10001)
					System.out.print(0+" ");
				else
					System.out.print(1+" ");
			}
			System.out.println();
		}
	}
	
}
