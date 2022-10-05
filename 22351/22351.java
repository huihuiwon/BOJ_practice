import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str = br.readLine();
    	
    	for(int k=1; k<=3; k++) {
    		if(k>str.length()) break;
	    	int a = Integer.parseInt(str.substring(0, k));
	    	int nxt = a;
	    	boolean flag = true;
	    	System.out.println(a);
	    	for(int i=k; i<str.length(); i++) {
	    		nxt += 1;
	    		
	    		if(i+(int)(Math.log10(nxt)+1)>str.length()) {
	    			flag=false;
	    			break;
	    		}
	    		int tmp = Integer.parseInt(str.substring(i, i+(int)(Math.log10(nxt)+1)));
	    		if(tmp == nxt) {
	    			i+=(int)(Math.log10(nxt));
	    		}
	    		else {
	    			flag = false;
	    			break;
	    		}
	    	}
	    	if(flag) {
	    		System.out.println(a+" "+nxt);
	    		break;
	    	}
    	}
    }
}
