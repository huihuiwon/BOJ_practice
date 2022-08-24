import java.io.*;
import java.util.*;


public class Main {		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		TreeMap<String, Double> hm = new TreeMap<>();
		int total=0;
		while((str=br.readLine())!= null) {
			total++;
			hm.put(str, hm.getOrDefault(str, 0.0)+1);
		}
		
		for(String s : hm.keySet()) {
			System.out.println(s+" "+String.format("%.4f", hm.get(s)/total*100));
		}
	}
}
