import java.io.*;
import java.util.*;


public class Main {

	static String a, b;
	static int len=0;
	static boolean flag=false;
	public static void chk(int L, String str) {
		if(flag) return;
		if(L==len) {
			if(str.equals(a)) {
				flag=true;
				System.out.println(1);
			}
			return;
		}

		int str_len = str.length();
		if(str.charAt(str_len-1)=='A')
			chk(L-1, str.substring(0, str.length()-1));
		if(str.charAt(0)=='B'){
			StringBuilder sb = new StringBuilder(str.substring(1, str.length()));
			sb = sb.reverse();
			chk(L-1, sb.toString());
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine();
		b = br.readLine();		
		len = a.length();
		
		chk(b.length(), b);
		if(!flag) System.out.println(0);
	}
}
