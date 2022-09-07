import java.util.*;
import java.io.*;


public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp[]= br.readLine().split(" ");
		int a = Integer.parseInt(tmp[0]); 
		int b = Integer.parseInt(tmp[1]); 
		int v = Integer.parseInt(tmp[2]);
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(a == v) {
			System.out.println(1);
			return;
		}
		
		int c = a-b;
		int now = v-a;
		bw.write((now%c==0 ? now/c : now/c+1) +1+"\n");
		bw.flush();
		bw.close();
	}
}

***
Scanner 로 했더니 시간초과
