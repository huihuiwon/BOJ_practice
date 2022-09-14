import java.util.*;
import java.io.*;


public class Main {	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int max = 0; String max_str="";
		  while (true) {
          String s = br.readLine();
          String tmp[] = s.toLowerCase().split("[^a-z-]");
          for(String t : tmp) {
            if(t.equals("e-n-d")) {
              System.out.println(max_str.toLowerCase());
              return;
            }
            if(max < t.length()) {
              max = t.length();
              max_str = t;
            }
          }
      }
	}	
}
