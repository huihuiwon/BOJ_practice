import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
    	int num[]= {3,2,1,2,3,3,2,3,3,2,2,1,2,2,1,2,2,2,1,2,1,1,1,2,2,1};
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String a = br.readLine(); String b = br.readLine();
    	int len = a.length();
    	int arr[]=new int[len]; int arr2[]=new int[len];
    	for(int i=0; i<len; i++) {
    		arr[i] = num[a.charAt(i)-'A'];
    	}
    	for(int i=0; i<len; i++) {
    		arr2[i] = num[b.charAt(i)-'A'];
    	}

    	int dp[][]=new int[len+len][len+len];
    	for(int i=0; i<len; i++) {
    		dp[0][i*2] = arr[i];
    		dp[0][i*2+1] = arr2[i];
    	}
    	
    	for(int k=1; k<len+len-1; k++) {
	    	for(int i=0; i<len+len-k; i++) {
	    		dp[k][i] = dp[k-1][i]+dp[k-1][i+1];
	    		if(dp[k][i] >= 10) dp[k][i] %= 10;
	    	}
    	}
    	
    	System.out.println(dp[len+len-2][0]+""+dp[len+len-2][1]);
    }
}
