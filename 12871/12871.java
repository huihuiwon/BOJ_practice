import java.util.*;
import java.io.*;


public class Main {

	public static int gcd(int a, int b) {
		if(b<=0) return a;
		return gcd(b, a%b);
	}

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String a = br.readLine(); String b = br.readLine();

    	int a_len = a.length();
    	int b_len = b.length();

    	int c = gcd(a_len, b_len);
    	int c_len = a_len*b_len/c;

    	String aa=""; String bb="";
    	for(int i=0; i<c_len/a_len; i++)
    		aa+=a;
    	
    	for(int i=0; i<c_len/b_len; i++)
    		bb+=b;
    	
    	if(aa.equals(bb)) {
    		System.out.println(1);
    	}
    	else
    		System.out.println(0);
    }
}
