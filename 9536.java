import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int tc = Integer.parseInt(br.readLine());
    	
    	while(tc-->0) {
    		ArrayList<String> hs = new ArrayList<>();
    		String tmp[] = br.readLine().split(" ");
    		for(String t : tmp) {
    			hs.add(t);
    		}
    		
    		String str="";
    		while(!str.equals("what does the fox say?")) {
    			str = br.readLine();
    			tmp = str.split(" ");
    		
    			
    			for(;;) {
    				if(hs.contains(tmp[2])) hs.remove(tmp[2]);
    				if(!hs.contains(tmp[2])) break;
    				
    			}

        	
    		}
    		for(String h: hs)
        		System.out.print(h+" ");
    		System.out.println();

    	}
    	
    }
}
