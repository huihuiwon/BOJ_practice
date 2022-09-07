import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {	
	static StringBuilder sb = new StringBuilder();
	
    public static void hanoi(int L, int a, int c) {
		if(L==0)
			return;
		hanoi(L-1, a, 6-a-c);
		sb.append(a+" "+c+"\n");
		hanoi(L-1, 6-a-c, c);
	}
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
		
        BigInteger b1 = new BigInteger("1");
        if(n==1) System.out.println(1);
        else {
        	for(int i=0; i<n; i++)
        		b1 = b1.multiply(new BigInteger("2"));
        }
        System.out.println(b1.subtract(new BigInteger("1")));

        if(n <= 20){
            hanoi(n, 1, 3);
			System.out.println(sb);
        }
	}
}
