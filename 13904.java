// 그리디 알고리즘


import java.util.*;
import java.io.*;


class Score implements Comparable<Score>{
	int d; int w;
	Score(int d, int w){
		this.d=d;
		this.w=w;
	}
	public int compareTo(Score o) {
		return o.d-this.d; // 날짜 기한이 넉넉한 순으로
	}

}
public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		
		ArrayList<Score> arr = new ArrayList<>();
		int n=sc.nextInt(); int max=0;
		for(int i=0; i<n; i++) {
			int d=sc.nextInt(); int w=sc.nextInt();
			max=Math.max(max, d);
			arr.add(new Score(d, w));
		}
		Collections.sort(arr);
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 금액이 큰 것부터 나와야하니까 reverseOrder()
		int result=0;
		for(int i=max; i>0; i--) {
			for(Score s : arr) {
				if(s.d==i) // 해당 날짜 안에 할 수 있다면, pq.offer()
					pq.offer(s.w);
				else if(s.d < i)
					break;
			}
			if(!pq.isEmpty()) // pq.isEmpty() 인 경우에는 poll()을 하면 안됨
				result += pq.poll();
		}

		
		System.out.println(result);
	}
	
}
