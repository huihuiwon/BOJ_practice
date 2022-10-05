import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
    	System.out.println("A".compareTo("B"));
    	System.out.println("B".compareTo("A"));
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int tc = Integer.parseInt(br.readLine());
    	
    	while(tc-->0) {
    		int n = Integer.parseInt(br.readLine());
    		
    		String tmp[] = br.readLine().split(" ");
    		StringBuilder sb = new StringBuilder();
    		sb.append(tmp[0]);
    		for(int i=1; i<n; i++) {
    			if(tmp[i].compareTo(sb.charAt(0)+"")>0) {
    				sb.append(tmp[i]);
    			}
    			else
    				sb.insert(0, tmp[i]);
    		}
    		
    		System.out.println(sb);
    	}
    }
}
