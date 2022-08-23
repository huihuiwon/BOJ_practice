import java.util.*;
import java.io.*;


class Lec implements Comparable<Lec>{
	int num;
	int s; int e;
	Lec(int num, int s, int e){
		this.num=num;
		this.s=s;
		this.e=e;
	}
	public int compareTo(Lec o) {
		if(this.s==o.s)
			return this.e-o.e;
		return this.s-o.s;
	}
}
public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<Lec> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			arr.add(new Lec(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(arr);
		int result=0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr.get(0).e);
		for(int i=0; i<n; i++) {
			while(!pq.isEmpty() && pq.peek() <= arr.get(i).s) {
				pq.poll();
			}
			pq.add(arr.get(i).e);
			result = Math.max(result, pq.size());
		}
		System.out.println(result);
	}
	
}
