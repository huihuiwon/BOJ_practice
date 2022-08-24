import java.io.*;
import java.util.*;


public class Main {		
	public static int uc(int a, int b) {
		if(b==0) return a;
		return uc(b, a%b);
	}
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String str= sc.next();
		String tmp[]=str.split(":");
		int a=Integer.parseInt(tmp[0]);
		int b=Integer.parseInt(tmp[1]);

		int div=uc(a, b);
		System.out.println(a/div+":"+b/div);
	}
}
