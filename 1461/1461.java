import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(); int m=sc.nextInt();
		Stack<Integer> pos = new Stack<>();
		Queue<Integer> neg = new LinkedList<>();
		
		int max=0; int arr[]=new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
			max=Math.max(max, Math.abs(arr[i]));
		}
		
		Arrays.sort(arr);

		for(int a : arr) {
			if(a<0) neg.add(a);
			else pos.add(a);
		}
		
		int result = 0;

		while(!pos.isEmpty()) {
			boolean flag=true;
			int tmp = 0;
			for(int i=0; i<m; i++) {
				if(pos.isEmpty()) break;
				if(pos.peek() == max) {
					flag=false;
				}
				tmp = Math.max(pos.pop(), tmp);
			}
			if(flag) result += tmp*2;
			else result += tmp;
		}

		
		while(!neg.isEmpty()) {
			boolean flag=true;
			int tmp = 0;
			for(int i=0; i<m; i++) {
				if(neg.isEmpty()) break;
				if(neg.peek() == -1*max) {
					flag=false;
				}
				tmp = Math.min(neg.poll(), tmp);
			}
			if(flag) result -= tmp*2;
			else result -= tmp;
    }
		System.out.println(result);
	}
	
}
