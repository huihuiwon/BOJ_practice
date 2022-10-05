import java.util.*;
import java.io.*;


class Word implements Comparable<Word>{
	String w; int fre; int len;
	Word(String w, int fre, int len){
		this.w = w;
		this.fre = fre;
		this.len = len;
	}
	
	public int compareTo(Word o) {
		if(this.fre==o.fre) {
			if(o.len==this.len)
				return this.w.compareTo(o.w);
			return o.len-this.len;	
		}
		return o.fre-this.fre;
	}
}
public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String tmp[] = br.readLine().split(" ");
    	
    	int n = Integer.parseInt(tmp[0]);
    	int m = Integer.parseInt(tmp[1]);
    	
    	String arr[] = new String[n];
    	HashMap<String, Integer> hm = new HashMap<>();
    	for(int i=0; i<n; i++) {
    		arr[i] = br.readLine();
    		hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
    	}

    	ArrayList<Word> al = new ArrayList<>();
    	for(String h : hm.keySet()) {
    		al.add(new Word(h, hm.get(h), h.length()));
    	}
    	
    	
    	Collections.sort(al);
    	
    	for(Word o : al) {
    		if(o.len >= m)
    			bw.write(o.w+"\n");
    	}
    	
    	bw.flush();
    	bw.close();
    }
}
