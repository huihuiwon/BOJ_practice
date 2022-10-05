import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int tc = Integer.parseInt(br.readLine());
    	
    	while(tc-->0) {
    		int n = Integer.parseInt(br.readLine());
    		HashMap<String, Integer> hm1 = new HashMap<>();
    		String s[] = br.readLine().split(" ");
    		for(int i=0; i<n; i++) {
    			hm1.put(s[i], i);
    		}
    		
    		HashMap<Integer, Integer> iti = new HashMap<>(); // int to int
    		s = br.readLine().split(" ");
    		for(int i=0; i<n; i++) {
    			iti.put(i, hm1.get(s[i]));
    		}
    		
    		String result[] = new String[n];
    		s = br.readLine().split(" ");
    		for(int i=0; i<n; i++) {
    			result[iti.get(i)] = s[i];
    		}
    		
    		for(String r : result)
    			System.out.print(r+" ");
    		System.out.println();
    	}
    	
    }
}
