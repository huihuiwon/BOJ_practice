import java.util.*;
import java.io.*;


public class Main {
	
	static int map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();

		int cnt=0;
		while(str.length()!=1) {
			int tmp = 0;
			for(char c : str.toCharArray()){
				tmp += c-'0';
			}
			
			cnt++;
			str = Integer.toString(tmp);
		}
		
		System.out.println(cnt);
		
		int result=Integer.parseInt(str);
		if(result == 3 || result == 6 || result == 9)
			System.out.println("YES");
		
		else
			System.out.println("NO");
	}
	
}
