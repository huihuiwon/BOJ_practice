import java.util.*;
import java.io.*;


public class Main {
	
	static int map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		int goal=Integer.parseInt(br.readLine());
		int size=(int)Math.sqrt(n*n);
		map=new int[size][size];

		int h=size/2; int w=size/2; int div=1;
		int r_h=0; int r_w=0;
		
		map[h][w]=1;
		for(int k=2; k<=n*n; k++) {
			if(div==1) {
				h--;
				map[h][w]=k;
				if(h==0 || map[h][w+1] == 0) div=2;
			}
			else if(div==2) {
				w++;
				map[h][w]=k;
				if(w==n-1 || map[h+1][w] == 0) div=3;
			}
			else if(div==3) {
				h++;
				map[h][w]=k;
				if(h==n-1 || map[h][w-1] == 0) div=4;
			}
			else {
				w--;
				map[h][w]=k;
				if(w==0 || map[h-1][w]==0) div=1;
			}
			
			if(goal == k) {
				r_h=h+1; r_w=w+1;
			}
		}
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				bw.write(map[i][j] +" ");
			}
			bw.write("\n");
		}
		
		if(goal == 1) {
			r_h = size/2+1; r_w=size/2+1;
		}
		bw.write(r_h+" "+r_w+"\n");
		bw.flush();
		bw.close();
	}
	
}
