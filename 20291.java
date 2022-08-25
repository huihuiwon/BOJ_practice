import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		TreeMap<String, Integer> hm = new TreeMap<>();
		for(int i=0; i<t; i++) {
			String str[]=br.readLine().split("\\.");
			hm.put(str[1], hm.getOrDefault(str[1], 0)+1);
		}
		
		for(String h : hm.keySet()) {
			System.out.println(h+" "+hm.get(h));
		}
	}
}
