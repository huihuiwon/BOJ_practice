import java.util.*;
import java.io.*;

class Present implements Comparable<Present> {
	int r, c, size;
	Present(int r, int c, int size){
		this.r=r;
		this.c=c;
		this.size=size;
	}
	public int compareTo(Present o) {
		return o.size-this.size;
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int j = sc.nextInt(); int n=sc.nextInt();
			ArrayList<Present> arr = new ArrayList<>();
			for(int i=0; i<n; i++) {
				int r=sc.nextInt(); int c=sc.nextInt();
				arr.add(new Present(r, c, r*c));
			}
			Collections.sort(arr);
			int cnt = 0;
			int sum = 0;
			for(Present p : arr) {
				if(p.size >= j) {
					cnt++;
					break;
				}
				else {
					cnt++;
					j -= p.size;
				}
			}
			System.out.println(cnt);
		}
	}
	
}
