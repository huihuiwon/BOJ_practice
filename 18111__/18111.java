import java.util.*;
import java.io.*;


public class Main {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int b = Integer.parseInt(tmp[2]);
        
        
		int map[][]=new int[n][m];
		int min=Integer.MAX_VALUE; int max=0;
		
		for(int i=0; i<n; i++) {
			tmp = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(tmp[j]);
				min=Math.min(min, map[i][j]);
				max=Math.max(max, map[i][j]);
			}
		}
		
		int result=Integer.MAX_VALUE; int height=0;

		for(int i=min; i<=max; i++) {
			int remove=0; int add=0;
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(map[j][k]-i >= 0) remove += (map[j][k]-i);
					else add += (i-map[j][k]);
				}
			}

			
			if(add-remove <= b) {				
				if(add+remove*2 <= result) {
					result=add+remove*2;
					height=i;
				}
			}
		}

		bw.write(result + " " + height);

        bw.flush();
        bw.close();
	}
	
}
