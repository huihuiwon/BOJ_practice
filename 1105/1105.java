import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); int k=sc.nextInt();
		int cnt=0;
		String nn = Integer.toString(n);
		String kk = Integer.toString(k);
		
		if(nn.length() != kk.length()) 
			System.out.println(0);
		else {
			for(int i=0; i<nn.length(); i++) {
				if(nn.charAt(i) == '8' && kk.charAt(i) == '8') {
					cnt++;
				}
				else if(nn.charAt(i) != kk.charAt(i))
					break;
			}
			System.out.println(cnt);
		}
	}
	
}
