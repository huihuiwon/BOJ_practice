import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt(); int b=sc.nextInt();
		int org_a=a;
		int n=sc.nextInt();
		int star[]=new int[n];
		for(int i=0; i<n; i++) {
			star[i]= sc.nextInt();
			if(b==star[i]) {
				System.out.println(1);
				return;
			}
		}
		
		int result = 0;
		
		while(a != b) {  // 무조건 즐겨찾기를 한 번은 사용했을 때 최소 경우
			int tmpi=1001; int tmp=1001;
			for(int s : star) {
				if(tmp > Math.abs(b-s) && tmpi!=s) {
					tmp = Math.abs(b-s);
					tmpi = s;
				}
			}

			result += Math.min(Math.abs(a-tmpi), 1);
			if(a==tmpi) {  // 무한루프 도는 것을 방지하기 위함 (더이상 즐겨찾기를 사용할 수 없는 경우)
				result += Math.abs(b-a);
				a=b;
				break;
			}
			a=tmpi;
		}
		
		System.out.println(Math.min(result, Math.abs(b-org_a)));  // 즐겨찾기를 사용하지 않았을 때와 비교
	}
	
}
