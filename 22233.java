import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String tmp[] = br.readLine().split(" ");

    	int n = Integer.parseInt(tmp[0]);
    	int m = Integer.parseInt(tmp[1]);
    	
    	HashSet<String> hs = new HashSet<>();
    	for(int i=0; i<n; i++) {
    		hs.add(br.readLine());
    	}
    	
    	for(int i=0; i<m; i++) {
    		tmp = br.readLine().split(",");
    		for(String t : tmp) {
    			if(hs.contains(t))
    				hs.remove(t);
    		}
        	System.out.println(hs.size());
    	}
    	
    }
}
