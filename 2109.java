import java.util.*;
import java.io.*;

class School implements Comparable<School>{
	int p; int d;
	School(int p, int d){
		this.p=p;
		this.d=d;
	}
	public int compareTo(School o) {
		return o.d-this.d;
	}
}
public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<School> arr =new ArrayList<>();
		int max=0;
		for(int i=0; i<n; i++) {
			int p=sc.nextInt(); int d=sc.nextInt();
			max=Math.max(max, d);
			arr.add(new School(p, d));
		}
		Collections.sort(arr);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int answer=0;
		for(int i=max; i>=1; i--) {
			for(School s : arr) {
				if(s.d == i) {
					pq.offer(s.p);
				}
				else if(s.d < i)   // 그냥 else break를 하면 s.d!=i 가 아닌 모든 상황에서 break해버림
					break;
			}
			if(!pq.isEmpty()) answer+=pq.poll();
		}
		System.out.println(answer);
	}
	
}
