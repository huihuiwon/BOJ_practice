import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String tmp [] = br.readLine().split(" ");
    	int n = Integer.parseInt(tmp[0]);
    	int m = Integer.parseInt(tmp[1]);
    	
    	String arr[] = new String[n];
    	for(int i=0; i<n; i++) {
    		arr[i] = br.readLine();
    	}
    	
    	int result=0;
    	for(int i=0; i<m; i++) {
    		String str = br.readLine();
    		for(int j=0; j<n; j++) {
    			if(arr[j].substring(0, str.length()).equals(str)) {
    				result++;
    				break;
    			}
    		}
    	}
    	System.out.println(result);
    }
}
