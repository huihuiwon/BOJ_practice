import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//		int one[]=new int[8]; int two[]=new int[8];
//		int three[]=new int[8]; int four[]=new int[8];
		int arr[][]=new int[4][8];
		
		for(int i=0; i<4; i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0; j<8; j++)
				arr[i][j] = tmp[j]-'0';
		}

		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			String[] tmp2 = br.readLine().split(" ");
			int a = Integer.parseInt(tmp2[0]) - 1; int dir = Integer.parseInt(tmp2[1]);
			
			int d[]=new int[4];
			d[a] = dir;
			for(int j=a-1; j>=0; j--) {
				if(arr[j][2] != arr[j+1][6]) {
					d[j] = -d[j+1];
				}
				else
					break;
			}
			for(int j=a+1; j<4; j++) {
				if(arr[j][6] != arr[j-1][2]) {
					d[j] = -d[j-1];
				}
				else
					break;
			}
			
			int tmp = 0;
			for(int j=0; j<4; j++) {
				if(d[j] == 1) {
					tmp = arr[j][7];
					for(int t = 7; t>0; t--)
						arr[j][t] = arr[j][t-1];
					arr[j][0] = tmp;
				}
				else if(d[j] == -1) {
					tmp = arr[j][0];
					for(int t = 0; t<7; t++)
						arr[j][t] = arr[j][t+1];
					arr[j][7] = tmp;
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<4; i++) {
			if(arr[i][0] == 1)
				sum += Math.pow(2, i);
		}
		
		System.out.println(sum);
	}
}
